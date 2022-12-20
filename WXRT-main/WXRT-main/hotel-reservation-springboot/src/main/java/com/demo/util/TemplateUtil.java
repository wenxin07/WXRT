package com.demo.util;

import com.demo.domain.Extra;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Component
public class TemplateUtil {
    public String formatMonth(Month month) {
        return month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }
}
