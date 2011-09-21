package exam.andexam;

import java.util.*;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class AndExam extends Activity {
	static final int SETTING_ACTIVITY = 1;
	class Example {
		Example(Class<?> acls, String aDesc) {
			cls = acls;
			Name = cls.getSimpleName();
			
			// _ 앞쪽의 접두는 제목에서 제외한다.
			if (mOmitChapter) {
				int underbar = Name.indexOf('_'); 
				if (underbar != -1) {
					Name = Name.substring(underbar + 1);
				}
			}
			Desc = aDesc;
		}
		Class<?> cls;
		String Name;
		String Desc;
	}
	
	ArrayList<Example> arExample = new ArrayList<Example>();

	// 요청한 장의 예제들을 배열에 채운다.
	void FillExample(int chapter) {
		arExample.clear();
		
		switch(chapter) {
		case 0: // 3장.
			arExample.add(new Example(C03_TextView.class, "텍스트 뷰 위젯 소개"));
			arExample.add(new Example(C03_ImageView.class, "이미지 뷰 위젯 소개. 세 개의 이미지를 출력한다"));
			arExample.add(new Example(C03_ButtonEdit.class, "버튼과 에디트를 배치하고 버튼 클릭 이벤트 처리"));
			arExample.add(new Example(C03_Horizontal1.class, "버튼 에디트 수평 배치"));
			arExample.add(new Example(C03_Horizontal2.class, "텍스트 수평 배치의 잘못된 예"));
			arExample.add(new Example(C03_Horizontal3.class, "텍스트 수평 배치의 예"));
			arExample.add(new Example(C03_Gravity1.class, "디폴트 좌상단 정렬"));
			arExample.add(new Example(C03_Gravity2.class, "화면 중앙에 텍스트 뷰 정렬"));
			arExample.add(new Example(C03_Gravity3.class, "수직으로만 중앙에 정렬"));
			arExample.add(new Example(C03_Gravity4.class, "수직 중앙,수평 오른쪽 정렬"));
			arExample.add(new Example(C03_lGravity1.class, "수평중앙에 텍스트 뷰 배치"));
			arExample.add(new Example(C03_lGravity2.class, "화면중앙에 텍스트 뷰 배치"));
			arExample.add(new Example(C03_lGravity3.class, "두 위젯을 화면 중앙에 배치"));
			arExample.add(new Example(C03_lGravity4.class, "두 속성의 차이 연구"));
			arExample.add(new Example(C03_Base1.class, "높이가 다른 위젯 베이스 정렬 예"));
			arExample.add(new Example(C03_Base2.class, "베이스 정렬을 하지 않은 예"));
			arExample.add(new Example(C03_Weight1.class, "1:3:1 비율로 리니어 영역 분할"));
			arExample.add(new Example(C03_Weight2.class, "1:2:3 비율로 리니어 영역 분할"));
			arExample.add(new Example(C03_Weight3.class, "수직 리니어 삼단 분할"));
			arExample.add(new Example(C03_Padding1.class, "여백이 전혀 없는 배치"));
			arExample.add(new Example(C03_Padding2.class, "마진 10을 적용한 배치"));
			arExample.add(new Example(C03_Padding3.class, "마진 10, 패딩 10을 적용한 배치"));
			break;
		case 1: // 4장.
			arExample.add(new Example(C04_Relative.class, "렐레티브 레이아웃의 상대적 배치"));
			arExample.add(new Example(C04_NameCard.class, "렐러티브를 이용한 명함철"));
			arExample.add(new Example(C04_NameCard2.class, "정렬을 잘못한 명함철"));
			arExample.add(new Example(C04_IfMissing.class, "layout_alignWithParentIfMissing 속성이 있을 때"));
			arExample.add(new Example(C04_IfMissing2.class, "layout_alignWithParentIfMissing 속성이 없을 때"));
			arExample.add(new Example(C04_Absolute.class, "앨슬루트 레이아웃의 절대좌표에 배치"));
			arExample.add(new Example(C04_NoAbsolute.class, "렐러티브를 이용한 절대 배치"));
			arExample.add(new Example(C04_Frame.class, "프레임으로 뷰를 겹쳐서 배치하기"));
			arExample.add(new Example(C04_Table.class, "표형태의 테이블로 배치"));
			arExample.add(new Example(C04_NestLayout.class, "레이아웃끼리 중첩"));
			arExample.add(new Example(C04_MultiPage.class, "프레임을 이용한 여러 페이지로 구성된 액티비티"));
			arExample.add(new Example(C04_LinearTable.class, "리니어를 이용한 테이블 배치"));
			arExample.add(new Example(C04_CodeLayout.class, "XML만으로 레이아웃 전개하기"));
			arExample.add(new Example(C04_CodeLayout2.class, "코드로 레이아웃 생성하여 배치"));
			arExample.add(new Example(C04_Inflation.class, "XML로 레이아웃 전개"));
			arExample.add(new Example(C04_Inflation2.class, "코드로 레이아웃 생성"));
			arExample.add(new Example(C04_Inflation3.class, "XML문서를 전개하여 배치"));
			arExample.add(new Example(C04_Inflation4.class, "텍스트 뷰만 전개하여 리니어에 추가하기"));
			arExample.add(new Example(C04_LayoutParameter.class, "레이아웃 전개"));
			arExample.add(new Example(C04_LayoutParameter2.class, "코드로 배치하면서 레이아웃 파라미터 지정"));
			arExample.add(new Example(C04_MarginParameter.class, "XML로 마진 주기"));
			arExample.add(new Example(C04_MarginParameter2.class, "코드로 마진 주기"));
			arExample.add(new Example(C04_SetParameter.class, "실행중에 레이아웃 파라미터 변경"));
			break;
		case 2: // 5장.
			arExample.add(new Example(C05_CustomView.class, "커스텀 뷰에 직접 그리기"));
			arExample.add(new Example(C05_Primitive1.class, "기본 도형-점,선,원,사각형,문자열"));
			arExample.add(new Example(C05_Primitive2.class, "기본 도형-둥근 사각형,타원,반원,다각선"));
			arExample.add(new Example(C05_AntiAlias.class, "안티 알리아싱 옵션"));
			arExample.add(new Example(C05_Stroke.class, "굵기, 끝장식, 조인 등 선의 속성"));
			arExample.add(new Example(C05_Style.class, "채움 및 외곽선 그리기 스타일"));
			arExample.add(new Example(C05_DrawBitmap.class, "비트맵 이미지 출력. 확대 및 일부 영역 출력"));
			arExample.add(new Example(C05_OffScreen.class, "메모리에서 비트맵 생성하기"));
			arExample.add(new Example(C05_DrawText.class, "텍스트 출력"));
			arExample.add(new Example(C05_TypeFace.class, "텍스트의 타입 페이스"));
			arExample.add(new Example(C05_CustomFont.class, "커스텀 폰트 사용하기"));
			arExample.add(new Example(C05_DrawPath.class, "패스 출력"));
			arExample.add(new Example(C05_LinearGrad.class, "직선 그래디언트"));
			arExample.add(new Example(C05_RadialGrad.class, "원형 그래디언트"));
			arExample.add(new Example(C05_SweepGrad.class, "원주 그래디언트"));
			arExample.add(new Example(C05_BitmapSdr.class, "비트맵 셰이더"));
			arExample.add(new Example(C05_ComposeSdr.class, "조합 셰이더"));
			arExample.add(new Example(C05_MirrorImage.class, "조합 셰이더를 이용한 반사 이미지"));
			arExample.add(new Example(C05_Shape.class, "셰이프 드로블 출력"));
			arExample.add(new Example(C05_Toast.class, "토스트 출력"));
			arExample.add(new Example(C05_Beep.class, "간단한 비프음"));
			arExample.add(new Example(C05_Vibrate.class, "폰 진동시키기"));
			break;
		case 3: // 6장.
			arExample.add(new Example(C06_HandleEvent.class, "여러 가지 이벤트 처리 방식 연구"));
			arExample.add(new Example(C06_HandlerOrder.class, "핸들러의 우선 순위"));
			arExample.add(new Example(C06_HandlerAccess.class, "핸들러에서 외부 변수 액세스"));
			arExample.add(new Example(C06_FreeLine.class, "터치 이벤트로 자유 곡선 그리기"));
			arExample.add(new Example(C06_MoveCircle.class, "키보드로 원 움직이기"));
			arExample.add(new Example(C06_Fruit.class, "위젯의 이벤트 처리 및 핸들러 통합"));
			arExample.add(new Example(C06_Fruit2.class, "onClick 속성으로 클릭 이벤트 처리"));
			arExample.add(new Example(C06_LongClick.class, "위젯의 롱클릭 처리"));
			arExample.add(new Example(C06_FocusTest.class, "포커스 이동(디폴트)"));
			arExample.add(new Example(C06_FocusTest2.class, "포커스 이동(순환)"));
			arExample.add(new Example(C06_Timer.class, "핸들러를 이용한 타이머"));
			break;
		case 4: // 7장.
			arExample.add(new Example(C07_OptionMenu.class, "옵션 메뉴, 서브 메뉴로 토스트 열어 보기"));
			arExample.add(new Example(C07_OptionMenuXml.class, "XML로 메뉴 정의하여 전개"));
			arExample.add(new Example(C07_MenuCheck.class, "메뉴로 체크 및 라디오 옵션 입력 및 출력"));
			arExample.add(new Example(C07_ContextMenu.class, "위젯에 컨텍스트 메뉴 부착"));
			arExample.add(new Example(C07_MemoryPower.class, "기억력 게임(도형)"));
			arExample.add(new Example(C07_MemoryPowerBaby.class, "기억력 게임(이미지)"));
			arExample.add(new Example(C07_MemoryPower2.class, "디버깅 실습을 위한 오류 프로젝트"));			
			arExample.add(new Example(C07_LogTest.class, "Log 기록 남기기"));
			break;
		case 5: // 8장.기본위젯
			arExample.add(new Example(C08_ReadResource.class, "리소스에서 문자열, 색상, 크기 읽기"));
			arExample.add(new Example(C08_ReadResource2.class, "레이아웃에서 리소스 읽기"));
			arExample.add(new Example(C08_Style.class, "스타일 계층 정의 및 사용"));
			arExample.add(new Example(C08_Theme.class, "액티비티에 타이틀바 없음 테마 적용"));
			arExample.add(new Example(C08_SystemTheme.class, "액티비티에 대화상자 테마 적용"));
			arExample.add(new Example(C08_TextViewAttr.class, "텍스트 뷰의 속성 연구"));
			arExample.add(new Example(C08_Spannable.class, "Spannable 버퍼 타입으로 서식 문자열 출력"));
			arExample.add(new Example(C08_Editable.class, "Editable 버퍼 타입으로 문자열 직접 수정"));
			arExample.add(new Example(C08_TextChange.class, "텍스트 변경 이벤트"));
			arExample.add(new Example(C08_GramPrice.class, "그램당 상품 가격 계산"));
			arExample.add(new Example(C08_EditLimit.class, "텍스트 입력 길이 제한"));
			arExample.add(new Example(C08_EditSelect.class, "선택 영역 관리"));
			arExample.add(new Example(C08_InputType.class, "inputType 속성으로 키보드의 종류 선택"));
			arExample.add(new Example(C08_ShowHideKey.class, "코드에서 키보드 보이기/숨기기"));
			arExample.add(new Example(C08_AdjustKey1.class, "키보드 Panning 모드"));
			arExample.add(new Example(C08_AdjustKey2.class, "키보드 Resize 모드"));
			arExample.add(new Example(C08_NoNinePatch.class, "보통 이미지 배경 사용"));
			arExample.add(new Example(C08_NinePatch.class, "나인패치 이미지 배경 사용"));
			arExample.add(new Example(C08_ArrowButton.class, "상태에 따라 색상이 변하는 화살표 버튼"));
			arExample.add(new Example(C08_RadioCheck.class, "라디오 버튼, 체크 박스"));
			arExample.add(new Example(C08_FilterTouch.class, "버튼의 터치 필터링 속성"));
			arExample.add(new Example(C08_ScaleType.class, "이미지 뷰의 확대 모드"));
			arExample.add(new Example(C08_ImageViewAttr.class, "이미지 뷰의 속성 연구"));
			arExample.add(new Example(C08_ImageButton.class, "이미지 버튼"));
			break;
		case 6: // 9장.어댑터 뷰
			arExample.add(new Example(C09_ListView.class, "리스트 뷰에 문자열 항목 표시"));
			arExample.add(new Example(C09_ListFromArray.class, "리스트 뷰에 XML 배열 표시"));
			arExample.add(new Example(C09_ListAttr.class, "리스트 뷰의 구분선 속성"));
			arExample.add(new Example(C09_ListAddDel.class, "실행중에 항목 삽입 및 삭제"));
			arExample.add(new Example(C09_ListAddDelMulti.class, "여러 개의 항목 한꺼번에 삭제하기"));
			arExample.add(new Example(C09_ListIconText.class, "아이콘과 텍스트로 항목 뷰 구성하기"));
			arExample.add(new Example(C09_ListOfViews.class, "여러 종류의 항목 뷰 섞어서 표시"));
			arExample.add(new Example(C09_ManyItem.class, "대용량 항목 뷰 표시와 리스트 뷰의 동작 연구"));
			arExample.add(new Example(C09_Expandable.class, "2단계의 확장 리스트 뷰"));
			arExample.add(new Example(C09_ListOnly.class, "ListActivity 사용"));
			arExample.add(new Example(C09_OverScroll.class, "리스트 뷰의 오버 스크롤 "));
			arExample.add(new Example(C09_Spinner.class, "스피너로 과일 이름 선택하기"));
			arExample.add(new Example(C09_Grid.class, "그리드 뷰로 이미지 선택하기"));
			arExample.add(new Example(C09_Gallery.class, "갤러리 뷰로 이미지 선택하기"));
			break;
		case 7: // 10장.고급 위젯
			arExample.add(new Example(C10_ProgressBar.class, "프로그래스 바"));
			arExample.add(new Example(C10_ProgressTitle.class, "타이틀바의 프로그래스 바"));
			arExample.add(new Example(C10_ProgressTitle2.class, "타이틀바의 원형 프로그래스"));
			arExample.add(new Example(C10_SeekBar.class, "시크 바"));
			arExample.add(new Example(C10_Rating.class, "래이팅 바"));
			arExample.add(new Example(C10_DateTime.class, "날짜 및 시간 조사 방법"));
			arExample.add(new Example(C10_Clock.class, "디지털, 아날로그 시계 위젯"));
			arExample.add(new Example(C10_DateTimePicker.class, "날짜, 시간 선택 위젯"));
			arExample.add(new Example(C10_PickerDialog.class, "날짜, 시간 선택 대화상자"));
			arExample.add(new Example(C10_Chronometer.class, "스톱워치 위젯"));
			arExample.add(new Example(C10_StopWatch.class, "핸들러로 구현한 스톱워치"));
			arExample.add(new Example(C10_AutoComplete.class, "자동 완성 에디트"));
			arExample.add(new Example(C10_MultiAuto.class, "자동 완성 멀티 에디트"));
			arExample.add(new Example(C10_SlidingDrawer.class, "화면 아래쪽에 숨겨진 서랍"));
			arExample.add(new Example(C10_ScrollView.class, "스크롤 뷰(색상 뷰 수직 스크롤)"));
			arExample.add(new Example(C10_HScrollView.class, "수평 스크롤 뷰"));
			arExample.add(new Example(C10_WebView.class, "웹 뷰-웹 페이지 및 리소스의 HTML 보기"));			
			arExample.add(new Example(C10_SportsScore.class, "스포츠 경기의 점수 매기기"));			
			break;
		case 8: // 11장.커스텀 위젯
			arExample.add(new Example(C11_SoundEdit.class, "문자 입력시마다 소리나는 커스텀 에디트 뷰"));
			arExample.add(new Example(C11_NumEdit.class, "입력문자수를 표시하는 조합 위젯"));
			arExample.add(new Example(C11_Attribute.class, "생성자로 전달되는 속성 집합 덤프"));
			arExample.add(new Example(C11_SoundEdit2.class, "커스텀 속성을 적용한 소리나는 에디트"));
			arExample.add(new Example(C11_Measuring.class, "onMeasure-wrap, wrap"));
			arExample.add(new Example(C11_Measuring2.class, "onMeasure-100, 50"));
			arExample.add(new Example(C11_Measuring3.class, "onMeasure-fill, fill"));
			arExample.add(new Example(C11_Measuring4.class, "onMeasure-버튼있는 fill, fill"));
			arExample.add(new Example(C11_Measuring5.class, "onMeasure-weight로 삼분할"));
			arExample.add(new Example(C11_Rainbow.class, "무지개 프로그래스 바 위젯"));
			break;
		case 9: // 12장.리소스 관리
			arExample.add(new Example(C12_LandPort.class, "화면 방향별 레이아웃 정의"));
			arExample.add(new Example(C12_MultiLang.class, "한글, 영어 다국어 지원"));
			arExample.add(new Example(C12_DisplayMetrics.class, "디스플레이 정보 조사"));
			arExample.add(new Example(C12_LogicUnit.class, "논리 단위를 사용해야 하는 이유 연구"));
			arExample.add(new Example(C12_ConvertDpi.class, "DPI 변환 유틸리티"));
			arExample.add(new Example(C12_ResDensity.class, "밀도별 리소스의 프리 스케일링"));
			arExample.add(new Example(C12_SameSize.class, "밀도에 무관하게 같은 크기로 이미지 출력"));
			arExample.add(new Example(C12_FillWidth.class, "레이아웃 폭 가득 채우기"));
			arExample.add(new Example(C12_DrawUnit.class, "실행중에 논리 단위를 픽셀로 변환하기"));
			arExample.add(new Example(C12_Ruler.class, "밀리, 인치 단위의 자"));
			arExample.add(new Example(C12_ScreenSize.class, "대화면의 레이아웃 정의"));
			break;
		case 10: // 13장.대화상자
			arExample.add(new Example(C13_Dialog.class, "Dialog 클래스를 이용한 대화상자"));
			arExample.add(new Example(C13_AlertDialog.class, "AlertDialog 대화상자"));
			arExample.add(new Example(C13_DialogButton.class, "대화상자에 닫기 버튼 배치"));
			arExample.add(new Example(C13_Cancelable.class, "Back 버튼 금지. 버튼을 눌러야 닫힘"));
			arExample.add(new Example(C13_ShowDialog.class, "대화상자 미리 생성해 놓기"));
			arExample.add(new Example(C13_ErrorMessage1.class, "에러 메시지 출력-안보임"));
			arExample.add(new Example(C13_ErrorMessage2.class, "에러 메시지 출력-보임"));
			arExample.add(new Example(C13_Question1.class, "질문하기의 잘못된 예"));
			arExample.add(new Example(C13_Question2.class, "질문후 응답 결과에 따라 연산하기"));
			arExample.add(new Example(C13_Question3.class, "3단계 질문 통합하기"));
			arExample.add(new Example(C13_SelectDialog1.class, "목록 선택. 항목 클릭 즉시 닫힘"));
			arExample.add(new Example(C13_SelectDialog2.class, "단일 선택. 항목 선택 후 확인 버튼"));
			arExample.add(new Example(C13_SelectDialog3.class, "복수 선택. 여러 항목 선택 후 확인 버튼"));
			arExample.add(new Example(C13_OrderDialog.class, "상품 주문 커스텀 대화상자"));
			arExample.add(new Example(C13_Popup.class, "팝업 윈도우 열기"));			
			break;
		case 11: // 14장.액티비티
			arExample.add(new Example(C14_CallActivity.class, "내부 액티비티 호출"));
			arExample.add(new Example(C14_CommActivity.class, "인텐트를 통한 액티비티간의 통신"));
			arExample.add(new Example(C14_CallOther.class, "여러 가지 외부 액티비티 호출"));
			arExample.add(new Example(C14_Add.class, "정수 덧셈 액티비티"));
			arExample.add(new Example(C14_CallAdd.class, "암시적 인텐트로 호출"));
			arExample.add(new Example(C14_ActParent.class, "생명주기 메서드 호출 순서 연구"));
			arExample.add(new Example(C14_SaveState.class, "상태 저장 안함. 화면 회전시 리셋"));
			arExample.add(new Example(C14_SaveState2.class, "x값만 임시적으로 저장"));
			arExample.add(new Example(C14_SaveState3.class, "x는 임시저장 y는 영구 저장"));
			arExample.add(new Example(C14_SaveCurve.class, "시리얼라이즈로 곡선 객체 저장"));
			arExample.add(new Example(C14_SaveCurve2.class, "Parcel 객체로 곡선 정보 저장"));
			arExample.add(new Example(C14_SaveCurve3.class, "액티비티 파괴 금지"));
			arExample.add(new Example(C14_TabTest.class, "탭-뷰의 id 지정"));
			arExample.add(new Example(C14_TabTest2.class, "탭-팩토리로 생성"));
			arExample.add(new Example(C14_TabTest3.class, "탭안에 액티비티 포함"));
			arExample.add(new Example(C14_CustomTab.class, "프레임을 이용한 커스텀 탭"));			
			break;
		case 12: // 15장.프로세스
			arExample.add(new Example(C15_ApplicationTest.class, "Application 객체 테스트"));
			arExample.add(new Example(C15_NoTitle.class, "타이틀 바 없음"));
			arExample.add(new Example(C15_FullScreen.class, "전체 화면 사용"));
			arExample.add(new Example(C15_CustomTitle.class, "커스텀 타이틀 바"));
			arExample.add(new Example(C15_Overlay.class, "레이아웃 겹치기"));
			arExample.add(new Example(C15_Center.class, "화면 중앙에 윈도우 열기"));
			arExample.add(new Example(C15_WindowManager.class, "윈도우 관리자"));
			arExample.add(new Example(C15_DragReorder.class, "드래그해서 항목 순서 변경하기"));
			break;
		case 13: // 16장.스레드
			arExample.add(new Example(C16_Thread.class, "스레드"));
			arExample.add(new Example(C16_Handler.class, "핸들러"));
			arExample.add(new Example(C16_Looper.class, "루퍼"));
			arExample.add(new Example(C16_Upload.class, "대화상자가 사라지지 않음"));
			arExample.add(new Example(C16_Post.class, "작업 등록 후 즉시 리턴"));
			arExample.add(new Example(C16_ANR.class, "ANR 문제"));
			arExample.add(new Example(C16_ANR2.class, "ANR 해결"));
			arExample.add(new Example(C16_StrictMode.class, "스트릭트 모드"));
			arExample.add(new Example(C16_LongTime.class, "긴 작업(블로킹)"));
			arExample.add(new Example(C16_LongTime2.class, "핸들러로 작업 경과 표시"));
			arExample.add(new Example(C16_LongTime3.class, "프로그래스로 경과 표시 및 취소"));
			arExample.add(new Example(C16_LongTime4.class, "스레드 사용"));
			arExample.add(new Example(C16_LongTime5.class, "AsyncTask 사용"));
			arExample.add(new Example(C16_BackWork.class, "백그라운드 작업"));
			arExample.add(new Example(C16_BackWork2.class, "백그라운드 작업-스레드"));
			arExample.add(new Example(C16_BackWork3.class, "백그라운드 작업-대기 스레드"));			
			break;
		case 14: // 17장.그리기
			arExample.add(new Example(C17_BlurFlt.class, "블러 필터"));
			arExample.add(new Example(C17_EmbossFlt.class, "임보싱 필터"));
			arExample.add(new Example(C17_ColorFlt.class, "색상 필터"));
			arExample.add(new Example(C17_ColorM.class, "이미지 반전"));
			arExample.add(new Example(C17_GrayScale.class, "그레이 스케일"));
			arExample.add(new Example(C17_Porter.class, "Porter, Duff의 색상 변환 규칙"));
			arExample.add(new Example(C17_DashPathEft.class, "선 모양 변경"));
			arExample.add(new Example(C17_CornerPathEft.class, "모서리 변경"));
			arExample.add(new Example(C17_PathDashEft.class, "화살표 모양 대시"));
			arExample.add(new Example(C17_DashAnim.class, "대시 애니메이션"));
			arExample.add(new Example(C17_Xfer.class, "Xfermode"));
			arExample.add(new Example(C17_Dither.class, "디더링"));
			arExample.add(new Example(C17_Translate.class, "이동 변환"));
			arExample.add(new Example(C17_Translate2.class, "문자열 연속 출력"));
			arExample.add(new Example(C17_SaveCanvas.class, "캔버스 상태 저장"));
			arExample.add(new Example(C17_Skew.class, "기울이기"));
			arExample.add(new Example(C17_Scale.class, "확대"));
			arExample.add(new Example(C17_TransOrder.class, "변환의 순서"));
			arExample.add(new Example(C17_Rotate.class, "회전 변환"));
			arExample.add(new Example(C17_Reflection.class, "SurfaceView 연구"));
			arExample.add(new Example(C17_Reflection2.class, "SurfaceView 연구"));
			arExample.add(new Example(C17_ReDraw1.class, "느린 그리기"));
			arExample.add(new Example(C17_ReDraw2.class, "객체 미리 생성"));
			arExample.add(new Example(C17_ReDraw3.class, "클리핑 최소화"));
			arExample.add(new Example(C17_ReDraw4.class, "지연된 그리기"));
			arExample.add(new Example(C17_ReDraw5.class, "비트맵 배경 사용"));			
			arExample.add(new Example(C17_OpenGL.class, "OpenGL 3D 그래픽 테스트"));
			break;
		case 15: // 18장.애니메이션
			arExample.add(new Example(C18_FrameAni.class, "프레임 애니메이션"));
			arExample.add(new Example(C18_Animation.class, "트윈 애니메이션"));
			arExample.add(new Example(C18_AnimAttr.class, "애니메이션의 속성"));
			arExample.add(new Example(C18_AnimSet.class, "애니메이션 집합"));
			arExample.add(new Example(C18_AnimCustom.class, "XML 문서로 애니메이션 정의"));
			arExample.add(new Example(C18_Tween.class, "트윈 애니메이션"));
			arExample.add(new Example(C18_TweenListener.class, "연속 애니메이션"));
			arExample.add(new Example(C18_ListAnim.class, "리스트 애니메이션"));
			arExample.add(new Example(C18_ListAnim2.class, "리스트 애니메이션"));
			arExample.add(new Example(C18_GridAnim.class, "그리드 애니메이션"));
			arExample.add(new Example(C18_GridAnim2.class, "그리드 애니메이션"));
			arExample.add(new Example(C18_ActAnim.class, "카메라 애니메이션"));
			arExample.add(new Example(C18_ViewFlipper.class, "애니메이션 뷰 교체"));
			arExample.add(new Example(C18_TextSwitcher.class, "애니메이션 텍스트 교체"));
			break;
		case 16: // 19장.파일
			arExample.add(new Example(C19_FileIO.class, "파일에 문자열 입출력 및 파일 삭제"));
			arExample.add(new Example(exam.external.C19_ShareFile.class, "패키지간 파일 공유"));
			arExample.add(new Example(C19_SDCard.class, "SD Card에 문자열 입출력"));
			arExample.add(new Example(C19_TextLogTest.class, "디버깅을 위한 텍스트 로그 클래스"));
			arExample.add(new Example(C19_PrefTest.class, "프레프런스에 정수와 문자열 저장"));
			arExample.add(new Example(C19_PrefActivity.class, "프레프런스 액티비티"));
			arExample.add(new Example(C19_TextPrefTest.class, "텍스트 프레퍼런스 테스트"));
			break;
		case 17: // 20장.CP
			arExample.add(new Example(C20_EnglishWord.class, "DB를 이용한 영어 단어장"));
			arExample.add(new Example(C20_ProductList.class, "커서와 연결된 리스트 뷰"));
			arExample.add(new Example(C20_CallWordCP.class, "영어 단어장 CP 호출"));			
			break;
		case 18: // 21장.네트워크
			arExample.add(new Example(C21_ConMgr.class, "연결 관리자로 연결 방법 덤프"));
			arExample.add(new Example(C21_DownHtml.class, "HTML로 웹 문서 다운로드"));
			arExample.add(new Example(C21_AsyncDownHtml.class, "HTML 비동기 다운로드"));
			arExample.add(new Example(C21_DownImage.class, "이미지 다운로드"));
			arExample.add(new Example(C21_WebService.class, "트위터로 사용자 정보 조사"));
			arExample.add(new Example(C21_DownloadManager.class, "다운로드 관리자로 다운로드 예약하기"));
			arExample.add(new Example(C21_DomParser.class, "DOM 파서로 문자열 값 조사"));
			arExample.add(new Example(C21_DomParser2.class, "DOM 파서로 복수 엘리먼트와 속성 읽기"));
			arExample.add(new Example(C21_SaxParser.class, "SAX 파서로 XML 문서 읽기"));
			arExample.add(new Example(C21_PullParser.class, "PULL 파서로 XML 문서 읽기"));
			arExample.add(new Example(C21_JSONArray.class, "JSON 정수 배열 읽어서 합산"));
			arExample.add(new Example(C21_JSONObject.class, "JSON 객체 읽어서 출력"));			
			break;
		case 19: // 22장.서비스
			arExample.add(new Example(C22_NapAlarm.class, "낮잠 시간을 알려 주는 알람 시계"));
			arExample.add(new Example(C22_CustomNotiView.class, "확장 상태란의 커스텀 통지 뷰"));
			arExample.add(new Example(C22_DetectFree.class, "공짜 네트워크 발견 방송 발송"));
			arExample.add(new Example(C22_DetectSaveZone.class, "할인 지역 발견 방송 발송"));
			arExample.add(new Example(C22_OnSaveZone.class, "할인 지역 발견 방송 청취 "));
			arExample.add(new Example(C22_WatchBattery.class, "배터리 감시하여 메시지 출력"));
			arExample.add(new Example(C22_WatchSdcard.class, "SdCard 감시하여 변화 출력"));
			arExample.add(new Example(C22_Alarm.class, "일회성 알람, 주기적 알람"));
			arExample.add(new Example(C22_NewsController.class, "뉴스 보기 서비스 관리"));
			arExample.add(new Example(exam.external.C22_NewsController.class, "외부 패키지에서 뉴스 보기"));
			arExample.add(new Example(C22_CalcClient.class, "서비스로 최소 공배수, 소수 여부 연산"));			
			arExample.add(new Example(exam.external.C22_CalcClient.class, "외부 패키지에서 서비스로 연산"));			
			break;
		case 20: // 23장.제스처
			arExample.add(new Example(C23_GestureDump.class, "제스처 이벤트 덤프"));
			arExample.add(new Example(C23_GestureNavi.class, "제스처로 좌우 이동하기"));
			arExample.add(new Example(C23_CustomGesture.class, "커스텀 제스처 인식"));
			arExample.add(new Example(C23_GestureOverlay.class, "제스처 오버레이"));
			arExample.add(new Example(C23_TouchDump.class, "터치 덤프"));
			arExample.add(new Example(C23_PinchZoom.class, "멀티 터치로 확대 및 축소"));
			arExample.add(new Example(C23_ImageZoom.class, "멀티 터치로 이미지 확대 및 축소"));
			break;
		case 21: // 24장.맵서비스
			arExample.add(new Example(C24_GetProvider.class, "위치 제공자 조사."));
			arExample.add(new Example(C24_ReadLocation.class, "현재 위치 읽기"));
			arExample.add(new Example(C24_LastKnown.class, "최근 위치 조사"));
			arExample.add(new Example(C24_LocationConvert.class, "포맷 변환"));
			arExample.add(new Example(C24_LocationAlert.class, "도착 알림"));
			arExample.add(new Example(C24_ViewLocation.class, "63빌딩 위치 보기"));
			arExample.add(new Example(C24_MapView.class, "맵뷰 테스트"));
			arExample.add(new Example(C24_GeoCoding.class, "지오 코딩"));
			arExample.add(new Example(C24_OverlayWidget.class, "오버레이 위젯"));
			arExample.add(new Example(C24_OverlayView.class, "오버레이 뷰"));
			arExample.add(new Example(C24_OverlayMulti.class, "오버레이 항목"));
			arExample.add(new Example(C24_OverlayLocation.class, "현재 위치 및 나침반"));
			break;
		case 22: // 25장.멀티미디어
			arExample.add(new Example(C25_MPTest.class, "MediaPlayer의 간단한 사용법 연구"));
			arExample.add(new Example(C25_PlayAudio.class, "MP3 음악 재생기"));
			arExample.add(new Example(C25_RecAudio.class, "레코더를 이용한 음성 녹음"));
			arExample.add(new Example(C25_SoundPool.class, "SoundPool 클래스 테스트"));
			arExample.add(new Example(C25_LoadComplete.class, "사운드 로드 완료 리스너"));
			arExample.add(new Example(C25_ChangeVolume.class, "볼륨 조절"));
			arExample.add(new Example(C25_PlayVideo.class, "테스트 동영상 재생"));
			arExample.add(new Example(C25_VideoView.class, "VideoView를 활용한 동영상 재생"));
			arExample.add(new Example(C25_RecVideo.class, "레코더를 이용한 영상 및 음성 녹화"));
			arExample.add(new Example(C25_DumpMedia.class, "미디어 DB의 구조와 목록을 조사한다."));
			arExample.add(new Example(C25_DumpMedia2.class, "미디어 목록의 변화에 대해 반응한다."));
			arExample.add(new Example(C25_ImageView.class, "미디어 DB의 이미지 보기"));
			arExample.add(new Example(C25_ImageGrid.class, "그리드 뷰로 이미지 보기"));
			arExample.add(new Example(C25_Camera.class, "촬영만 가능한 카메라 예제"));
			arExample.add(new Example(C25_SHCamera.class, "포커싱,해상도,접사,리뷰 지원 카메라"));
			break;
		case 23: // 26장.하드웨어
			arExample.add(new Example(C26_SensorManager.class, "센서 관리자로 지원되는 센서 정보 출력"));
			arExample.add(new Example(C26_SensorDump.class, "모든 센서값을 출력해 본다."));
			arExample.add(new Example(C26_Compass.class, "방향 센서를 이용한 나침반 및 수평계"));
			arExample.add(new Example(C26_Accelerator.class, "가속 센서의 값 변화를 그래픽으로 보기"));
			arExample.add(new Example(C26_MotionCounter.class, "가속 센서를 이용한 카운터"));
			arExample.add(new Example(C26_ShakeCounter.class, "흔들기를 이용한 카운터"));
			arExample.add(new Example(C26_ScreenFlash.class, "뒤집으면 밝아지는 후레쉬"));
			arExample.add(new Example(C26_getOrientation.class, "회전 행렬을 이용한 방향 조사"));
			arExample.add(new Example(C26_Ottogi.class, "항상 위쪽으로 서는 오뚜기"));
			arExample.add(new Example(C26_WakeAlways.class, "항상 켜 있기"));
			arExample.add(new Example(C26_ReadingCounter.class, "독서 도우미"));
			arExample.add(new Example(C26_UserInteraction.class, "사용자 입력"));
			arExample.add(new Example(C26_GetSetting.class, "설정값 조사"));
			arExample.add(new Example(C26_SetSetting.class, "설정값 변경"));
			arExample.add(new Example(C26_WallPaper.class, "벽지 변경"));
			break;
		case 24: // 27장.전화
			arExample.add(new Example(C27_TelState.class, "전화 상태 조사"));
			arExample.add(new Example(C27_TelCall.class, "전화 걸기"));
			arExample.add(new Example(C27_YieldCall.class, "통화중 대기"));
			arExample.add(new Example(C27_YieldCall2.class, "게임중 통화시 잠시 멈춤"));
			arExample.add(new Example(C27_FormatNumber.class, "전화 번호 관리"));
			arExample.add(new Example(C27_CallSms.class, "문자 메시지 프로그램 호출"));
			arExample.add(new Example(C27_SendSms.class, "문자 메시지 보내기"));
			arExample.add(new Example(C27_ReceiveSms.class, "문자 메시지 받기"));
			arExample.add(new Example(C27_ReadContactOld.class, "1.6 이전의 주소록 덤프"));
			arExample.add(new Example(C27_ReadContact.class, "주소록 덤프"));
			arExample.add(new Example(C27_CallLog.class, "통화 기록 덤프"));
			arExample.add(new Example(C27_SmsLog.class, "문자 메시지 덤프"));
			break;
		case 25: // 28장.앱위젯
			arExample.add(new Example(C28_AppWidgetManager.class, "앱 위젯 관리자"));
			break;
		}
	}
	
	String[] arChapter = {
			"3장 레이아웃",
			"4장 레이아웃 관리",
			"5장 출력",
			"6장 입력",
			"7장 메뉴",
			"8장 기본 위젯",
			"9장 어댑터 뷰",
			"10장 고급 위젯",
			"11장 커스텀 위젯",
			"12장 리소스 관리",
			"13장 대화상자",
			"14장 액티비티(act)",
			"15장 프로세스",
			"16장 스레드",
			"17장 그리기",
			"18장 애니메이션",
			"19장 파일",
			"20장 CP",
			"21장 네트워크",
			"22장 서비스",
			"23장 제스처",
			"24장 맵 서비스",
			"25장 멀티미디어",
			"26장 하드웨어",
			"27장 전화",
			"28장 앱위젯",
		};
	
	ArrayAdapter<CharSequence> mAdapter;
	ListView mExamList;
	Spinner mSpinner;
	boolean mInitSelection = true;
	int mFontSize;
	int mBackType;
	boolean mDescSide;
	boolean mOmitChapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.andexam);

		mExamList = (ListView)findViewById(R.id.examlist);
		mSpinner = (Spinner)findViewById(R.id.spinnerchapter);
		mSpinner.setPrompt("장을 선택하세요.");

		mAdapter = new ArrayAdapter<CharSequence>(this, 
				android.R.layout.simple_spinner_item, arChapter);
		mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(mAdapter);

		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// 최초 전개시에도 Selected가 호출되는데 이때는 프레퍼런스에서 최후 장을 찾아 로드한다.
				// 이후부터는 사용자가 선택한 장을 로드한다.
				if (mInitSelection) {
					mInitSelection = false;
					SharedPreferences pref = getSharedPreferences("AndExam", 0);
					int lastchapter = pref.getInt("LastChapter", 0);
					mSpinner.setSelection(lastchapter);
					ChangeChapter(lastchapter);
				} else {
					// 장을 변경할 때마다 프레퍼런스에 기록한다.
					ChangeChapter(position);
					SharedPreferences pref = getSharedPreferences("AndExam", 0);
					SharedPreferences.Editor edit = pref.edit();
					edit.putInt("LastChapter", position);
					edit.commit();
				}
			}
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		ReadOption();

		// 자동실행 옵션의 디폴트는 false로 설정한다. 한 예제만 반복적으로 테스트할 때 이 옵션을
		// 사용하되 예외 처리가 어려우므로 왠만하면 사용하지 않는 것이 좋다.
		boolean bRunLast = false;
		if (bRunLast) {
			SharedPreferences pref = getSharedPreferences("AndExam", 0);
			int pkg = pref.getInt("LastChapter", 0);
			int pos = pref.getInt("LastPosition", 0);
			ChangeChapter(pkg);
			Intent intent = new Intent(this, arExample.get(pos).cls);
			startActivity(intent);
		}
	}
	
	public void ReadOption() {
		SharedPreferences pref = getSharedPreferences("AndExam", 0);
		mFontSize = pref.getInt("mFontSize", 1);
		mBackType = pref.getInt("mBackType", 0);
		mDescSide = pref.getBoolean("mDescSide", false);
		mOmitChapter = pref.getBoolean("mOmitChapter", false);;
		
		if (mBackType != 0) {
			mExamList.setBackgroundColor(0xff101010);
			mExamList.setDivider(new ColorDrawable(0xff606060));
			mExamList.setDividerHeight(1);
		} else {
			mExamList.setBackgroundColor(0xffe0e0e0);
			mExamList.setDivider(new ColorDrawable(0xff404040));
			mExamList.setDividerHeight(1);
		}
	}
	
	public void ChangeChapter(int chapter) {
		FillExample(chapter);
		ExamListAdapter Adapter = new ExamListAdapter(this);
		mExamList.setAdapter(Adapter);

		final Context ctx = this;
		mExamList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				SharedPreferences pref = getSharedPreferences("AndExam", 0);
				SharedPreferences.Editor edit = pref.edit();
				edit.putInt("LastPosition", position);
				edit.commit();
				Intent intent = new Intent(ctx, arExample.get(position).cls);
				startActivity(intent);
			}
		});
	}
	
	public void mOnClick(View v) {
		SharedPreferences pref = getSharedPreferences("AndExam", 0);
		int lastchapter = pref.getInt("LastChapter", 0);
		switch (v.getId()) {
		case R.id.btnprev:
			if (lastchapter != 0) {
				lastchapter--;
				mSpinner.setSelection(lastchapter);
			}
			break;
		case R.id.btnnext:
			if (lastchapter != arChapter.length -1) {
				lastchapter++;
				mSpinner.setSelection(lastchapter);
			}
			break;
		}
	}
	
	//어댑터 클래스
	class ExamListAdapter extends BaseAdapter {
		Context maincon;
		LayoutInflater Inflater;

		public ExamListAdapter(Context context) {
			maincon = context;
			Inflater = (LayoutInflater)context.getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return arExample.size();
		}

		public String getItem(int position) {
			return arExample.get(position).Name;
		}

		public long getItemId(int position) {
			return position;
		}

		// 각 항목의 뷰 생성
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = Inflater.inflate(R.layout.andexamlist, parent, false);
			}
			
			LinearLayout examlayout = (LinearLayout)convertView.findViewById(R.id.examlayout);
			TextView txt1 = (TextView)convertView.findViewById(R.id.text1);
			TextView txt2 = (TextView)convertView.findViewById(R.id.text2);

			if (mDescSide) {
				examlayout.setOrientation(LinearLayout.HORIZONTAL);
			}
			
			if (mBackType != 0) {
				examlayout.setBackgroundResource(R.drawable.exambackdark);
				txt1.setTextColor(Color.WHITE);
				txt2.setTextColor(Color.LTGRAY);
			}

			switch (mFontSize) {
			case 0:
				txt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
				txt2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 9);
				break;
			case 1:
				txt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
				txt2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
				break;
			case 2:
				txt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
				txt2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
				break;
			}
			
			txt1.setText(arExample.get(position).Name);
			txt2.setText(arExample.get(position).Desc);

			return convertView;
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
	
		menu.add(0,1,0,"소개");
		menu.add(0,2,0,"옵션");
		menu.add(0,3,0,"종료");

		return true;
	}

	boolean mbRunLast;
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			new AlertDialog.Builder(this)
    		.setTitle("프로그램 소개")
    		.setMessage("안드로이드 프로그래밍 정복(한빛미디어)의 예제 모음 프로그램입니다.\n" +
    				"상단의 스피너에서 패키지를 선택하고 목록에서 예제를 선택하십시오.")
    		.setIcon(R.drawable.andexam)
    		.setPositiveButton("닫기", null)
    		.show();
			return true;
		case 2:
			startActivityForResult(new Intent(this, AndExamSetting.class), SETTING_ACTIVITY);
			return true;
		case 3:
			finish();
			System.exit(0);
			return true;
		}
		return false;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case SETTING_ACTIVITY:
			if (resultCode != RESULT_OK) return;
			ReadOption();
			SharedPreferences pref = getSharedPreferences("AndExam", 0);
			int lastchapter = pref.getInt("LastChapter", 0);
			ChangeChapter(lastchapter);
			break;
		}
	}
}
