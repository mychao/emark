package com.mychao.emark.controller.api;

import com.mychao.emark.dto.request.SuggestRequestDto;
import com.mychao.emark.dto.response.SuggestResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author myc
 * @version 2016/8/4
 */
@Controller
@RequestMapping("/api/suggest")
public class SuggestApi {

    /**
     * 搜索提示
     * @param suggestRequestDto
     * @return
     */
    @ResponseBody
    @PostMapping
    public String suggest(SuggestRequestDto suggestRequestDto){
        SuggestResponseDto suggestResponseDto = new SuggestResponseDto();
        suggestResponseDto.setKeyword(suggestRequestDto.getKeyword());
        suggestResponseDto.setTimestamp(suggestRequestDto.getTimestamp());
        StringBuilder suggestResult = new StringBuilder(suggestRequestDto.getTimestamp());
        suggestResult.append("|<div class=\"list-group query-sug\">");
        suggestResult.append("<a href='/diy/gudonghuijueyizengzi' class='list-group-item'><b>电源</b>开关\n" +
                "\t\t\t<span class='badge' onclick=\"window.location.href='/contract/interest';return false;\">电源</span>\n" +
                "\t\t\t<div class='clearfix'></div></a>");
        suggestResult.append("<a href='/diy/gudonghuijueyizengzi' class='list-group-item'><b>电源</b>开关2\n" +
                "\t\t\t<span class='badge' onclick=\"window.location.href='/contract/interest';return false;\">电源</span>\n" +
                "\t\t\t<div class='clearfix'></div></a>");
        suggestResult.append("<a href='/diy/gudonghuijueyizengzi' class='list-group-item'><b>电源</b>开关3\n" +
                "\t\t\t<span class='badge' onclick=\"window.location.href='/contract/interest';return false;\">电源</span>\n" +
                "\t\t\t<div class='clearfix'></div></a>");
        suggestResult.append("</div>");
        suggestResponseDto.setSuggestResult(suggestResult.toString());
        return suggestResult.toString();
    }

}
