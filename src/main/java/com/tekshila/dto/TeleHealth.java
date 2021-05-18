package com.tekshila.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TeleHealth {
    private String name;
    private String phone;
    private String zoomCall;
    private String teleUrl;
}
