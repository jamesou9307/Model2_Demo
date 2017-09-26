package com.james.model2.validator;

import com.james.model2.entity.ProductForm;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {//用于校验用户输入的信息是否符合要求

    public List<String> validate(ProductForm productForm){//存储错误信息

        List<String> errors=new ArrayList<>();
        String productName=productForm.getProductName();
        if(null==productName||productName.trim().isEmpty()){
            errors.add("product shoule have a name");
        }
        String price=productForm.getPrice();
        if(null==price||price.trim().isEmpty()){
            errors.add("prpduct should have a price");
        }else{
            try {
                float realPrice=Float.parseFloat(price);
            }catch (NumberFormatException ne){
                errors.add("invalid price value");
            }
        }
        return errors;
    }

}
