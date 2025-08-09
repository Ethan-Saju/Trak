package com.trak.trak.controllers;

import com.trak.trak.payload.APIResponse;
import com.trak.trak.payload.habit.HabitCreateDTO;
import com.trak.trak.payload.habit.HabitDTO;
import com.trak.trak.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private HabitService habitService;

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping("/{appUserId}")
    public ResponseEntity<List<HabitDTO>> getHabits(
            @PathVariable Long appUserId,
            @RequestParam("type") String type
    ) {
        return new ResponseEntity<>(habitService.getHabits(appUserId, type), HttpStatus.OK);
    }

    @GetMapping("/{appUserId}/{habitId}")
    public ResponseEntity<HabitDTO> getHabit(
            @PathVariable Long appUserId,
            @PathVariable Long habitId
    ) {
        return new ResponseEntity<>(habitService.getHabit(appUserId, habitId), HttpStatus.OK);
    }

    @PostMapping("/{appUserId}")
    public ResponseEntity<HabitDTO> createHabit(
            @PathVariable Long appUserId,
            @RequestBody HabitCreateDTO habitCreateDTO
    ) {
        return new ResponseEntity<>(habitService.createHabit(appUserId, habitCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{appUserId}/{habitId}")
    public ResponseEntity<HabitDTO> updateHabit(
            @PathVariable Long appUserId,
            @PathVariable Long habitId,
            @RequestBody HabitCreateDTO habitCreateDTO
    ) {
        return new ResponseEntity<>(habitService.updateHabit(appUserId, habitId, habitCreateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{appUserId}/{habitId}")
    public ResponseEntity<APIResponse> deleteHabit(
            @PathVariable Long appUserId,
            @PathVariable Long habitId
    ) {
        return new ResponseEntity<>(habitService.deleteHabit(appUserId, habitId), HttpStatus.OK);
    }



}
