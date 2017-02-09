package org.otojunior.sample.other;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteDog {
	@Test
    public void testDog() {
        final String expectedBarkSound = "woof";
        final String expectedColor = "brown";

        final Dog dog = DogFactory.builder()
            .barkSound(expectedBarkSound)
            .color(expectedColor)
            .build();
        
        assertEquals(expectedBarkSound, dog.getBarkSound());
        assertEquals(expectedColor, dog.getColor());
    }
}
