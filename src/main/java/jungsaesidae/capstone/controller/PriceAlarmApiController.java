package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.domain.PriceAlarm;
import jungsaesidae.capstone.dto.PriceAlarm.PriceAlarmDto;
import jungsaesidae.capstone.dto.Request.PriceAlarmRequest;
import jungsaesidae.capstone.service.PriceAlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pricealarm")
public class PriceAlarmApiController {

    private final PriceAlarmService priceAlarmService;

    @GetMapping("/{userId}")
    public List<PriceAlarmDto> searchPriceAlarm(@PathVariable("userId") Long userId) {
        return priceAlarmService.findAllByUserId(userId);
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addPriceAlarm(@RequestBody PriceAlarmRequest request) {
        return ResponseEntity.ok(priceAlarmService.add(request.getUserId(), request.getItemId(), request.getTargetPrice()));
    }

    // also not sure which one is better.

    @DeleteMapping("/delete/{userId}/{itemId}")
    public void delete(@PathVariable("userId") Long userId, @PathVariable("itemId") Long itemId) {
        // 이 알람의 유무를 컨트롤러에서 체크 or 서비스단에서 체크?
        priceAlarmService.delete(userId, itemId);
    }

    @DeleteMapping("/delete/{priceAlarmId}")
    public void delete(@PathVariable("priceAlarmId") Long priceAlarmId) {
        priceAlarmService.delete(priceAlarmId);
    }
}
