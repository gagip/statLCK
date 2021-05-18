<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <div class="row row-cols-1">
    <!-- 전광판 -->
    <div id="elc-board" class="col mt-4 mb-4">
      <!-- 전광판 헤더 -->
      <h3 class="pb-4 mb-4 fst-italic border-bottom">
        최근 LCK 일정
      </h3>
      <!-- 전광판 컨텐츠 -->
      <div class="row justify-content-evenly align-items-center border">
        <!-- 이전 -->
        <div class="col-md-3 p-4">
          <div class="d-flex flex-column border p-2">
            <div><strong>5월 10일</strong></div>
            <div class="row align-items-center align-items-stretch">
              <!-- 왼쪽 -->
              <div class="col align-self-center d-flex flex-column">
                <img src="<%=request.getContextPath()%>/static/img/dwg.png" class="img-thumbnail" style="height: 60px;">
                <div class="fs-5 align-self-center">담원</div>
                <div class="fs-3 align-self-center text-danger">2</div>
              </div>
              
              <div class="col-1 align-self-center fs-5 text-center p-0">vs</div>
              
              <!-- 오른쪽 -->
              <div class="col align-self-center d-flex flex-column">
                <img src="<%=request.getContextPath()%>/static/img/t1.png" class="img-thumbnail" style="height: 60px;">
                <div class="fs-5 align-self-center">T1</div>
                <div class="fs-3 align-self-center text-success">3</div>
              </div>
            </div>
          </div>
        </div>

        <!-- 최근 경기 -->
        <div class="col-md-5 p-4">   
          <div class="d-flex flex-column border p-3">
            <div><strong>5월 11일</strong></div>
            <div class="row align-items-center align-items-stretch p-3">
              <!-- 왼쪽 -->
              <div class="col align-self-center d-flex flex-column">
                <img src="<%=request.getContextPath()%>/static/img/dwg.png" class="img-thumbnail" style="height: 120px;">
                <div class="fs-5 align-self-center">담원</div>
                <div class="fs-3 align-self-center text-danger">0</div>
              </div>
              
              <div class="col-2 align-self-center fs-3 text-center p-0">vs</div>
              
              <!-- 오른쪽 -->
              <div class="col align-self-center d-flex flex-column">
                <img src="<%=request.getContextPath()%>/static/img/gen-g.png" class="img-thumbnail" style="height: 120px;">
                <div class="fs-5 align-self-center">젠지</div>
                <div class="fs-3 align-self-center text-success">2</div>
              </div>
            </div>

            <!-- 응원 -->
            <div class="btn btn-danger w-75 align-self-center">
              응원하기
            </div>
          </div>
          
        </div>
        <!-- 이후 -->
        <div class="col-md-3 p-4">
          <div class="d-flex flex-column border p-2">
            <div><strong>5월 12일</strong></div>
            <div class="row align-items-center align-items-stretch">
              <!-- 왼쪽 -->
              <div class="col align-self-center d-flex flex-column">
                <img src="<%=request.getContextPath()%>/static/img/DRX.png" class="img-thumbnail" style="height: 60px;">
                <div class="fs-5 align-self-center">DRX</div>
                <div class="fs-3 align-self-center">0</div>
              </div>
              
              <div class="col-1 align-self-center fs-5 text-center p-0">vs</div>
              
              <!-- 오른쪽 -->
              <div class="col align-self-center d-flex flex-column">
                <img src="<%=request.getContextPath()%>/static/img/gen-g.png" class="img-thumbnail" style="height: 60px;">
                <div class="fs-5 align-self-center">젠지</div>
                <div class="fs-3 align-self-center">0</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 팀 랭킹 -->
    <div class="col mt-4 mb-4">
      <!-- 팀 랭킹 헤더 -->
      <h3 class="pb-4 mb-4 fst-italic border-bottom">
        팀 랭킹
      </h3>

      <!-- 팀 랭킹 내용 -->
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">순위</th>
            <th scope="col">팀 이름</th>
            <th scope="col">승률</th>
            <th scope="col">승</th>
            <th scope="col">패</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>DWG</td>
            <td>100%</td>
            <td>6</td>
            <td>0</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Gen.G</td>
            <td>50%</td>
            <td>3</td>
            <td>3</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>T1</td>
            <td>43%</td>
            <td>3</td>
            <td>4</td>
          </tr>
          <tr>
            <th scope="row">4</th>
            <td>Nongshim</td>
            <td>40%</td>
            <td>2</td>
            <td>3</td>
          </tr>
          <tr>
            <th scope="row">5</th>
            <td>Hanwha</td>
            <td>38%</td>
            <td>3</td>
            <td>5</td>
          </tr>
          <tr>
            <th scope="row">6</th>
            <td>DRX</td>
            <td>25%</td>
            <td>1</td>
            <td>3</td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 선수 랭킹 -->
    <div class="col mt-4 mb-4">
      <!-- 선수 랭킹 헤더 -->
      <h3 class="pb-4 mb-4 fst-italic border-bottom">
        선수 랭킹
      </h3>
      <!-- 팀 랭킹 내용 -->
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">순위</th>
            <th scope="col">선수 이름</th>
            <th scope="col">승률</th>
            <th scope="col">승</th>
            <th scope="col">패</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>DWG</td>
            <td>100%</td>
            <td>6</td>
            <td>0</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Gen.G</td>
            <td>50%</td>
            <td>3</td>
            <td>3</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>T1</td>
            <td>43%</td>
            <td>3</td>
            <td>4</td>
          </tr>
          <tr>
            <th scope="row">4</th>
            <td>Nongshim</td>
            <td>40%</td>
            <td>2</td>
            <td>3</td>
          </tr>
          <tr>
            <th scope="row">5</th>
            <td>Hanwha</td>
            <td>38%</td>
            <td>3</td>
            <td>5</td>
          </tr>
          <tr>
            <th scope="row">6</th>
            <td>DRX</td>
            <td>25%</td>
            <td>1</td>
            <td>3</td>
          </tr>
        </tbody>
      </table>
    </div>

  </div>
</div>