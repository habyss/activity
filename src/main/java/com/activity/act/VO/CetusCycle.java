package com.activity.act.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CetusCycle {
    private String id;
    private String timeLeft;
    private Date expiry;
    private Boolean isDay;
    private Boolean isCetus;
    private String shortString;
}
