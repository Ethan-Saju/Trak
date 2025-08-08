package com.trak.trak.controllers;

import com.trak.trak.payload.habit.HabitDTO;
import com.trak.trak.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new ResponseEntity<>(HabitService.getHabits(appUserId, type), HTTPStatus.OK);
    }


}
