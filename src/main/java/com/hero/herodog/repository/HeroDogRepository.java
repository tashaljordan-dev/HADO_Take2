package com.hero.herodog.repository;

import com.hero.herodog.model.HeroDog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HeroDogRepository extends JpaRepository<HeroDog, Long> {
}
