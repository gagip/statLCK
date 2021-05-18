var tab_select = $("#tab .active");

$(document).ready(function(){
  // HTML 파일 분리 (임시) 
  //$("#headers").load("common/header.html");
  //$("#side-nav").load("common/side_nav.html");
  //$("#tab").load("common/tab.html");
  //$("#tab-content").load("common/tab_content.html");
  
  // setActive();
});


function setActive(){
  let url = window.location.href;

  $('li a').each(function() {
    if (this.href === url) {
      $(this).closest('li a').addClass('active');
    }
  });
} 

$('#tab .nav-link').click(function(){
  var tab_id = $(this).attr('data-tab');

  $('#tab .nav-link').removeClass('active');
  $('.tab-pane').removeClass('show active');

  $(this).addClass('active');
  $("#"+tab_id).addClass('show active');
})




