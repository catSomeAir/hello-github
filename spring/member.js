

//회원정보의 유효성 판단처리

var member = {
	//태그의 상태판단 : 키보드 입력시 입력값을 태그별로 확인
	tag_status : function( tag ){
		//태그의 name속성
		var name = tag.attr('name');
		if( name == 'userpw') return this.userpw_status( tag.val() );		//내부에있는 함수사용이므로 this. 필요
		else if( name == 'userpw_ck') return this.userpw_ck_status(tag.val());
	},
	//비밀번호 확인 입력값 상태확인 : 비밀번호와 입력값이 동일한지
	userpw_ck_status: function(pw_ck){
		if(pw_ck == '')								return this.common.empty;
		else if(pw_ck == $('[name=userpw]').val()) 	return this.userpw.equal;
		else 										return this.userpw.notEqual;
	},
	
	//비밀번호 입력값 상태 확인 : 영문 대,소문자, 숫자 모두 포함
	userpw_status : function( pw ){
		//정규식판단 : 시작 / , [^뭐부터-뭐] , /g 전체에서
		var reg = /[^a-zA-Z0-9]/g, upper=/[A-Z]/g, lower=/[a-z]/g, digit=/[0-9]/g;		
		
		//비번이 입력안됐으면 입력하도록 하라
		if( pw == '') return this.common.empty;
		
		//비번에 공백있으면 
		else if( pw.match(this.space))  return this.common.space;
		else if( reg.test(pw))			return this.userpw.invalid
		//비번 글자수		
		else if( pw.length < 5)			return this.common.min;
		else if( pw.length >= 10)		return this.common.max;
		
		else if( ! upper.test(pw) || ! lower.test(pw) 
		|| ! digit.test(pw))			return this.userpw.lack;
		else 							return this.userpw.valid;
		
	},
	
	userpw : {
		equal: { code : 'valid', desc:'비밀번호가 일치'},
		notEqual: { code : 'invalid', desc:'비밀번호가 일치하지 않습니다'},
		valid : { code : 'valid', desc : '사용가능한 비밀번호'},
		invalid : { code:'invalid', desc:'영문 대/소문자, 숫자만 입력'},
		lack : { code : 'invalid', desc:'영문 대/소문자, 숫자를 모두 포함'}
		
	},
	
	//g : 전체 , \s 스페이스
	space : /\s/g,
	
	
	//공통사용 상태값
	common : {
		//입력이 안된경우
		empty: { code:'invalid', desc:'입력하세요'},
		//공백입력경우
		space: { code:'invalid', desc:'공백없이 입력하세요'},
		//최대,최소 입력길이
		min: { code:'invalid', desc:'5글자 이상 입력하세요'},
		max: { code:'invalid', desc:'10글자 이하로 입력하세요'}
		
	}
	
	
	
	
}