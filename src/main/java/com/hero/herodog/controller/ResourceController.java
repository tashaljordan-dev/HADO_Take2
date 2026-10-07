package com.hero.herodog.controller;

import com.hero.herodog.model.Resource;
import com.hero.herodog.repository.ResourceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "*")
public class ResourceController {

    private final ResourceRepository resourceRepository;

    public ResourceController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @GetMapping
    public List<Resource> getResources() {
        return resourceRepository.findAll();
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource resource) {
        return resourceRepository.save(resource);
    }

    @PutMapping("/{id}")
    public Resource updateResource(
            @PathVariable Long id,
            @RequestBody Resource resource) {

        Resource existing = resourceRepository.findById(id)
                .orElseThrow();

        existing.setTitle(resource.getTitle());
        existing.setDescription(resource.getDescription());
        existing.setUrl(resource.getUrl());

        return resourceRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceRepository.deleteById(id);
    }
}