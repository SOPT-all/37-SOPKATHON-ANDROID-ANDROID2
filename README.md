# 37-SOPKATHON-ANDROID-ANDROID2
37기 솝커톤 안드로이드 2팀 안드로이드 레포입니다.

## 서비스 이름 및 소개
### 📱 서비스 이름: 핸즈업

### ✏️ 소개: 대학생들이 자유롭게 안건을 내고 투표할 수 있는 민주적 플랫폼

<br>

### 핵심 기능 도출

**`안건 등록하기`**

학생들이 자율적으로 투표하고 싶은 안건을 등록할 수 있는 기능

- 안건 제목과 상세 설명을 입력할 수 있음.
- 투표 범위 (전교생, 단과대, 학과)를 설정할 수 있음.
- 안건 제안 후 21일 동안 해당 안건에 대해 추천을 받을 수 있음.
- 안건 등록은 상시 등록 가능

**`안건 추천하기`**

안건 탭 페이지에서 등록된 안건들을 학생들이 추천할 수 있는 기능

→ 일정 추천 수가 넘어가면 ‘투표 안건’으로 넘어가 투표 기간에 투표를 진행하게 됨

- 유권자의 30% 이상이 추천한 안건은 “투표” 안건으로 넘어가 투표를 받게됨.
- 전체 안건 중 투표 가능 임계치까지 가장 적은 추천수가 남은 안건은 “안건 탭 페이지”의 “정책변화” 바로 밑에 배너로 표시됨.
    - “자세히 보기”를 눌러 다른 추천수 기준 충족 임박 안건들도 볼 수 있음(구현X)

**`안건 투표하기`**

추천하기 단계에서 선정된 안건들을 학생들이 찬성/반대로 투표하는 기능

- 란츠게마인더의 특성을 살려 ‘손 들기’, ‘손 안 들기’로 표현됨
- 매달 말일 전 3일 동안 (eg. 11월: 28~30일) 투표기간이 행사되어 추천 기준을 충족해 투표 안건으로 넘어온 안건에 대해 투표를 진행하게 됨
- 찬성표(손 들기)가 반대표(손 안 들기)보다 많은 안건은 해당 안건을 담당하는 학생회 측으로 전달됨.

**`정책변화`**

투표 이후 총학생회가 해당 안건을 실제 교내 정치에 도입한 과정 및 결과를 학생들에게 공유하는 기능

- 변화된 내용은 안건 탭 페이지에서 해당 안건 범위를 담당하는 부서(전교→총학생회, 단과대→단과대 학생회, 학과→ 학과 학생회 등)가 업로드.

<br>

## 역할 분담

|<img src="https://avatars.githubusercontent.com/u/144779368?v=4" width="128" />|<img src="https://avatars.githubusercontent.com/u/107687577?v=4" width="128" />|<img src="https://avatars.githubusercontent.com/u/65026631?v=4" width="128" />|<img src="https://avatars.githubusercontent.com/u/132898771?v=4" width="128" />| 
|:---------:|:---------:|:---------:|:---------:|
|[정소희](https://github.com/sohee6989)|[성규현](https://github.com/dmp100)|[신형철](https://github.com/ShinHyeongcheol)|[유수현](https://github.com/sssuhha)|
| `안건 추천하기-2` `기초 세팅` | `안건 추천하기-1` | `컬러, 폰트 세팅` `안건 투표하기` | `안건 등록하기` |

<br>

## 컨벤션 규칙, 브랜치 전략

[Git Convention](https://cedar-algebra-b50.notion.site/Git-Branch-Convention-2b394d5d7d3f804db424fa44fa6d8589?pvs=74)

[Kotlin Convention](https://cedar-algebra-b50.notion.site/2b394d5d7d3f8048a854fddece19117b?pvs=73)

## 😆 Before
<img width="480" height="600" alt="스크린샷 2025-11-23 오전 12 41 41" src="https://github.com/user-attachments/assets/81c576a4-4354-4ebd-8023-c688529597ba" />
<img width="480" height="600" alt="스크린샷 2025-11-23 오전 1 34 50" src="https://github.com/user-attachments/assets/4b1996be-390a-4c41-9f07-b3797efabe70" />



