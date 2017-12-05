package com.imooc.security.core.validate.code.image;

import com.imooc.security.core.validate.code.ValidateCode;
import lombok.Data;

import java.awt.image.BufferedImage;

@Data
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }
}
