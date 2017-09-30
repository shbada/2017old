package com.flowershop.like.controller;

public class LikeController {
/** 추천수는 '상품 상세페이지'와 관련 - product 패키지 안에 복붙할 예정이라 전체 주석처리입니당 */

	/** 컨트롤러 */
/*	@RequestMapping(value="/likeSelect", method=RequestMethod.GET)
	@ResponseBody
	public int LikeSelect(@RequestParam int productNo) {
		int resultCnt = productService.LikeSelect(productNo); //추천수 가져옴
		return resultCnt;
	}
	
	@RequestMapping(value="/likeUpSave", method=RequestMethod.POST)
	@ResponseBody
	public String LikeUpSave(@ModelAttribute ProductVo productVo, HttpSession session) throws IOException{
		productVo.setUserId((String) session.getAttribute("userId"));
		ProductVo productLike= productService.LikeUpSelect(productVo);
		if(productLike == null){
			productService.likeUpSave(productVo); 
			return "ok";
		}
		else return "fal";
	}*/
	
	/** dao */
	
	/** daoImpl */

	/** service */
	
	/** serviceImpl */
	
	/** SQL쿼리 */
	/*
<select id="LikeSelect" resultType="int">
	SELECT COUNT(PRODUCT_NO) FROM LIKES WHERE PRODUCT_NO=#{productNo}
</select>


<select id="LikeUpSelect" parameterType="com.flowershop.product.vo.ProductVo" resultType="com.flowershop.product.vo.ProductVo">
	SELECT  PRODUCT_NO,
     USER_ID,
     PRODUCT_RECDATE
		FROM LIKES
        WHERE PRODUCT_NO = #{productNo}
        AND USER_ID = #{userId}
</select>


<insert id="likeUpSave" parameterType="com.flowershop.product.vo.ProductVo">
<![CDATA[
 INSERT 
   INTO LIKES(
     PRODUCT_NO,
     USER_ID,
     PRODUCT_RECDATE
   ) VALUES (
     #{productNo},
     #{userId},
     TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')
   )
]]>
</insert>

*/
	

/** jsp
 <form class="form-horizontal" name="frm">
 //form 태그 안에 상품 정보가 있고, 추천수 버튼을 누르면 form 태그 안의 정보가 controller로 전송됨을 위해!!
 </form>
 
 
<button type="button" class="btn btn-success btn-s-xs" id="LikeUp">추천</button>
*/
	
/** javascript
 
 function LikeSelect(){
		$.ajax({
			type : "GET",
			url : "<c:url value='/LikeSelect.do?productNo=${productVo.productNo}' />",
			success : function(result){
				$("#추천수 id값").html(result); 
			}
		});
		
		
		
 $("#LikeUp").click(function(){ 
			if(confirm("추천 하시겠습니까?")==true){
				//ajax통신 끝나면 리스트 페이지 이동
				var formData = $("form[name=frm]").serialize(); //값을 다가지고와서 변수에 담는다 (리스트형식으로 값이 들어감)
				$.ajax({
					type:"POST",
					url: "<c:url value='/likeSelect.do'/>",
					dataType:"text",
					data: formData,
					success: function(result){
						if(result == 'ok'){
							alert("추천이 완료되었습니다.");
							LikeSelect();
						}
						if(result == 'fal'){
							alert("이미 추천한 상품입니다.");
						}
					},
					error: function(result){
						alert('에러가 발생하였습니다.');
						return;
					},
				});
			}
		});
 
*/
}
