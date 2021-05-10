var data = [
  {name: "DWG", value: 1.00},
  {name: "Gen.G", value: 0.50},
  {name: "T1", value: 0.43},
  {name: "Nongshim", value: 0.40},
  {name: "Hanwha", value: 0.38},
  {name: "DRX", value: 0.25},
]

var margin = ({top: 30, right: 0, bottom: 30, left: 20});
var width = 100;
var height = 100;
var color = "steelblue";

yAxis = g => g
  .attr("transform", `translate(${margin.left},0)`)
  .call(d3.axisLeft(y).ticks(null, data.format))
  .call(g => g.select(".domain").remove())
  .call(g => g.append("text")
      .attr("x", -margin.left)
      .attr("y", 10)
      .attr("fill", "currentColor")
      .attr("text-anchor", "start")
      .text(data.name));

xAxis = g => g
  .attr("transform", `translate(0,${height - margin.bottom})`)
  .call(d3.axisBottom(x).tickFormat(i => data[i].name).tickSizeOuter(0));


y = d3.scaleLinear()
  .domain([0, d3.max(data, d => d.value)]).nice()
  .range([height - margin.bottom, margin.top]);

x = d3.scaleBand()
  .domain(d3.range(data.length))
  .range([margin.left, width - margin.right])
  .padding(0.1);




chart = function(data) {
  const svg = d3.select("body").append("svg")
      .attr("viewBox", [0, 0, width, height]);

  svg.append("g")
    .attr("fill", color)
    .selectAll("rect")
    .data(data)
    .join("rect")
      .attr("x", (d, i) => x(i))
      .attr("y", d => y(d.value))
      .attr("height", d => y(0) - y(d.value))
      .attr("width", x.bandwidth());

  svg.append("g")
    .call(xAxis);

  svg.append("g")
    .call(yAxis);

  return svg.node();
}

chart(data);