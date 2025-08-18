package com.trak.trak.controllers;

import com.trak.trak.payload.habitLog.HabitLogDTO;
import com.trak.trak.payload.habitLog.HabitLogUpdateDTO;
import com.trak.trak.services.HabitLogService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/habitLogs")
public class HabitLogController {
    private final HabitLogService habitLogService;

    public HabitLogController(HabitLogService habitLogService) {
        this.habitLogService = habitLogService;
    }

    @GetMapping("/{appUserId}")
    public ResponseEntity<List<HabitLogDTO>> getHabitLogs(@PathVariable Long appUserId) {
        return new ResponseEntity<>(habitLogService.getHabitLogs(appUserId), HttpStatus.OK);
    }

    @PatchMapping("/{appUserId}/habitLogID")
    public ResponseEntity<HabitLogDTO> updateHabitLog(
            @PathVariable Long appUserId,
            @PathVariable Long habitLogId,
            @RequestBody HabitLogUpdateDTO habitLogUpdateDTO
    ) {
        return new ResponseEntity<>(habitLogService.updateHabitLog(appUserId, habitLogId, habitLogUpdateDTO), HttpStatus.OK);
    }

    @GetMapping("/{appUserId}/{habitId}")
    public ResponseEntity<List<HabitLogDTO>> getHabitLogsByDate(
            @PathVariable Long appUserId,
            @PathVariable Long habitId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return new ResponseEntity<>(habitLogService.getHabitLogsByDate(appUserId, habitId, startDate, endDate), HttpStatus.OK);
    }
}
