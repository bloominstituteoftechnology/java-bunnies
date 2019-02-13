package com.lamdaschool.bunnies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BunnyRepository extends JpaRepository<Bunny, Long>
{
}
