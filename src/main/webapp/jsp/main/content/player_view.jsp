<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- https://www.bootdey.com/snippets/view/profile-with-data-and-skills#css -->
<div class="container">
  <div class="main-body">
  <!-- Breadcrumb -->
  <nav aria-label="breadcrumb" class="main-breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="index.html">Home</a></li>
      <li class="breadcrumb-item"><a href="javascript:void(0)">T1</a></li>
      <li class="breadcrumb-item active" aria-current="page">Faker</li>
    </ol>
  </nav>
  
  <!-- /Breadcrumb -->
  <div class="row gutters-sm">
    <div class="col-md-4 mb-3">
      
      <!-- 프로필 start -->
      <div class="card">
        <div class="card-body">
          <div class="d-flex flex-column align-items-center text-center">
            <img src="<%=request.getContextPath()%>/static/img/player/faker.png" alt="Admin" class="rounded-circle" width="150">
            <div class="mt-3">
              <h4>Faker(이상혁)</h4>
              <p class="text-secondary mb-1">미드라이너</p>
              <p class="text-muted font-size-sm">Hide on bush, 1135567del</p>
              <button class="btn btn-primary">통계</button>
              <button class="btn btn-outline-primary">응원</button>
            </div>
          </div>
        </div>
      </div>
      <!-- 프로필 end -->
      <!-- 챔피언 start -->
      <div class="card mt-3">
        <ul class="list-group list-group-flush">
          <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
            <h6 class="mb-0">신드라</h6>
            <span class="text-secondary">53%(91게임) 2.58</span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
            <h6 class="mb-0">루시안</h6>
            <span class="text-secondary">48%(64게임) 2.44</span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
            <h6 class="mb-0">조이</h6>
            <span class="text-secondary">53%(58게임) 3.17</span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
            <h6 class="mb-0">사일러스</h6>
            <span class="text-secondary">57%(44게임) 2.59</span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
            <h6 class="mb-0">비에고</h6>
            <span class="text-secondary">54%(41게임) 2.69</span>
          </li>
        </ul>
      </div>
      <!-- 챔피언 emd -->
    </div>
    
    <!-- 플레이어 누적통계 start -->
    <div class="col-md-8">
      
      <!-- 플레이어 시즌통계 start -->
      <div class="card mb-3">
        <div class="card-body">
          <div class="row">
            <div class="col-sm-3">
              <h6 class="mb-0">전적</h6>
            </div>
            <div class="col-sm-9 text-secondary">
              15W-8L
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-sm-3">
              <h6 class="mb-0">KDA</h6>
            </div>
            <div class="col-sm-9 text-secondary">
              5.7
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-sm-3">
              <h6 class="mb-0">분당 CS</h6>
            </div>
            <div class="col-sm-9 text-secondary">
              8.2
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-sm-3">
              <h6 class="mb-0">분당 골드</h6>
            </div>
            <div class="col-sm-9 text-secondary">
              390
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-sm-3">
              <h6 class="mb-0">킬 지분</h6>
            </div>
            <div class="col-sm-9 text-secondary">
              68.9%
            </div>
          </div>
        </div>
      </div>
      <!-- 플레이어 시즌통계 end -->
      <!-- 플레이어 스탯 start -->
      <div class="row gutters-sm">
        <div class="col-sm-6 mb-3">
          <div class="card h-100">
            <div class="card-body">
              <h6 class="d-flex align-items-center mb-3">전투 스탯</h6>
              <small>KDA</small>
              <div class="progress mb-3" style="height: 5px">
                <div class="progress-bar bg-primary" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              <small>킬 관여율</small>
              <div class="progress mb-3" style="height: 5px">
                <div class="progress-bar bg-primary" role="progressbar" style="width: 72%" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              <small>팀원 보조 점수</small>
              <div class="progress mb-3" style="height: 5px">
                <div class="progress-bar bg-primary" role="progressbar" style="width: 89%" aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              <small>데스당 피해량</small>
              <div class="progress mb-3" style="height: 5px">
                <div class="progress-bar bg-primary" role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              <small>기여한 피해량</small>
              <div class="progress mb-3" style="height: 5px">
                <div class="progress-bar bg-primary" role="progressbar" style="width: 66%" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-6 mb-3">
            <div class="card h-100">
              <div class="card-body">
                <h6 class="d-flex align-items-center mb-3">맵 장악 스탯</h6>
                <small>목표물 제어 지원율</small>
                <div class="progress mb-3" style="height: 5px">
                  <div class="progress-bar bg-primary" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <small>시간당 시야 점수</small>
                <div class="progress mb-3" style="height: 5px">
                  <div class="progress-bar bg-primary" role="progressbar" style="width: 72%" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <small>공격로 지원 점수</small>
                <div class="progress mb-3" style="height: 5px">
                  <div class="progress-bar bg-primary" role="progressbar" style="width: 89%" aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <small>킬 관여율</small>
                <div class="progress mb-3" style="height: 5px">
                  <div class="progress-bar bg-primary" role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- 플레이어 스탯 end -->
      </div>
      <!-- 플레이어 누적통계 end -->
    </div>
  </div>
</div>