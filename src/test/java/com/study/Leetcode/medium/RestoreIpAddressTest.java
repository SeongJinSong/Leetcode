package com.study.Leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RestoreIpAddressTest {
    @Test
    void restoreIpAddresses(){
        RestoreIpAddress obj = new RestoreIpAddress();
        assertLinesMatch(List.of("255.255.11.135","255.255.111.35"), obj.restoreIpAddresses("25525511135"));
        assertLinesMatch(List.of("0.0.0.0"), obj.restoreIpAddresses("0000"));
        assertLinesMatch(List.of("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"), obj.restoreIpAddresses("101023"));
    }
}