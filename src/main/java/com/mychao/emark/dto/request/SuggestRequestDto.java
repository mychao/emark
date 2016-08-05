package com.mychao.emark.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author myc
 * @version 2016/8/4
 */
@Setter
@Getter
public class SuggestRequestDto {
    private String keyword;
    private String timestamp;
}
