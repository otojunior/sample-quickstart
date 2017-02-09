package org.otojunior.sample.other;

import lombok.Builder;

public class DogFactory {
	@Builder
    private static Dog newDog(String color, String barkSound) {
        final Dog dog = new Dog();
        dog.setBarkSound(barkSound);
        dog.setColor(color);
        return dog;
    }
}
