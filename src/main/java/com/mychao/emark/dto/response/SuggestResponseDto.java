package com.mychao.emark.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author myc
 * @version 2016/8/4
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuggestResponseDto {
    private String keyword;
    private String timestamp;
    private String suggestResult;
}
