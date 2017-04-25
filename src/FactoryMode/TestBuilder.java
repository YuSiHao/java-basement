package FactoryMode;

import BuilderMode.Builder;

public class TestBuilder {  
	  
    public static void main(String[] args) {  
        Builder builder = new Builder();  
        builder.produceMailSender(10);  
    }  
}