package com.mealtracker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.mealtracker.models.Meal;
import com.mealtracker.repository.MealRepository;
import com.mealtracker.web.exceptions.ResourceNotFoundException;

@RestController
public class MealController {

  @Autowired
  private MealRepository mealRepository;

  @GetMapping("/meals")
  public Page<Meal> getMeals(Pageable pageable) {
    return mealRepository.findAll(pageable);
  }


  @PostMapping("/meals")
  public Meal createMeal(@Valid @RequestBody Meal meal) {
    return mealRepository.save(meal);
  }

  @PutMapping("/meals/{mealId}")
  public Meal updateMeal(@PathVariable Long mealId, @Valid @RequestBody Meal mealRequest) {
    return mealRepository.findById(mealId)
      .map(meal -> {
        meal.setName(mealRequest.getName());
        meal.setDescription(mealRequest.getDescription());
        return mealRepository.save(meal);
      }).orElseThrow(() -> new ResourceNotFoundException("Meal not found with id " + mealId));
  }


  @DeleteMapping("/meals/{mealId}")
  public ResponseEntity<?> deleteMeal(@PathVariable Long mealId) {
    return mealRepository.findById(mealId)
      .map(meal -> {
        mealRepository.delete(meal);
        return ResponseEntity.ok().build();
      }).orElseThrow(() -> new ResourceNotFoundException("Meal not found with id " + mealId));
  }
}