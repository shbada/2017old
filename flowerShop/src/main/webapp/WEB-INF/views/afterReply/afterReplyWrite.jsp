<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
 <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>After Reply</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="post" action="#">
                                <div id="customer_details" class="col2-set">
                                    <div class="col-1">
                                        <div class="woocommerce-billing-fields">
                                            <h3>Billing Details</h3>
                                            <p id="billing_country_field" class="form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated">
                                                <label class="" for="billing_country">상품후기 만족도
                                                </label>
                                                <select class="country_to_state country_select" id="billing_country" name="billing_country">
                                                    <option value="">5점-매우만족</option>
                                                    <option value="AX">4점-만족</option>
                                                    <option value="AX">3점-보통</option>
                                                    <option value="AX">2점-조금부족</option>
                                                    <option value="AX">1점-부족</option>
                                                </select>
                                            </p>

                                            <p id="billing_first_name_field" class="form-row form-row-first validate-required">
                                                <label class="" for="billing_first_name">상품 후기내용
                                                </label>
                                                <textarea type="text" placeholder="" id="billing_first_name" name="billing_first_name" class="input-text "></textarea>
                                            </p>
                                            
                                             <input type="submit" value="후기등록" name="update_cart" class="button">
                                        </div>
                                    </div>
                                 </div>
                            </form>                      
                    </div>                    
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>