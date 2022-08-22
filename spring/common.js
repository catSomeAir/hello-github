/**
 *  공통 함수
 */
$(function(){
	
	$.datepicker.setDefaults({
		dateFormat: 'yy-mm-dd',
		changeYear: true,
		changeMonth: true,
		showMonthAfterYear: true,
		monthNamesShort: ['1월','2월','3월','4월','5월','6월'
							,'7월','8월','9월','10월','11월','12월'],
		dayNamesMin: ['일','월','화','수','목','금','토']
	});
	
	
});

//입력여부 판단함수
function emptyCheck(){
	//정상처리 확인
	var ok = true;
	
	$('.chk').each(function(){
		if($(this).val()==''){
			//placeholder값 가져오기
			var item = $(this).attr('placeholder')
			alert(item+' 입력하세요!');
			$(this).focus();
			
			//걸리면 false리턴시키기
			ok = false;
			return ok;
		}
	});
	return ok;
}



