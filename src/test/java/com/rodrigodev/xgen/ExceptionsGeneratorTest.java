package com.rodrigodev.xgen;

import org.junit.Test;

import static com.rodrigodev.xgen.ErrorConfiguration.*;
import static com.rodrigodev.xgen.ParameterDefinition.p;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 12/05/15.
 */
public class ExceptionsGeneratorTest {

    public ExceptionsGeneratorTest() {
        createExceptions();
    }

    private void createExceptions() {

        ExceptionsGenerator xgen = new ExceptionsGenerator("src/test-gen/java");

        // @formatter:off
        xgen.generate(baseError("House").errors(
                commonError("Common").errors(
                        error("Room").errors(
                                error("Dirty").description("%s is dirty!", p(String.class, "roomName")).build(),
                                error("TooSmall").description("%s is too damn small!", p(String.class, "roomName")).build(),
                                error("BadSmell").description("%s smells bad, really bad.", p(String.class, "roomName")).build()
                        ).build(),
                        error("Appliance").description("Something went wrong with %s appliance.", p(String.class, "applianceName")).errors(
                                error("Damaged").description("%s has been damaged.", p(String.class, "applianceName")).build(),
                                error("Discharged").description("%s is discharged.", p(String.class, "applianceName")).build(),
                                error("Scratches").description("%s got some scratches.", p(String.class, "applianceName")).build()
                        ).build()
                ).build(),
                error("Kitchen").errors(
                        error("Fridge").errors(
                                error("FoodNotFound").description("Food %s not found! I'm starving.", p(String.class, "foodName")).build(),
                                error("FrozenFood").description("%s is frozen! How could you possibly eat that?", p(String.class, "foodName")).build(),
                                error("RottenFood").description("%s is rotten my friend.", p(String.class, "foodName")).build()
                        ).build(),
                        error("Oven").description("The oven is not working. Model: %s", p(String.class, "model")).errors(
                                error("Undercooked").description("%s is undercooked my friend, I won't eat that.", p(String.class, "model")).build(),
                                error("BurnedFood").description("Damn, %s just burned! We better order some pizza.", p(String.class, "model")).build(),
                                error("TooMuchSmoke").description( "Wow, there is too much smoke coming out from the oven. Do you think %s is okay?", p(String.class, "model")).build()
                        ).build()
                ).build(),
                error("Bedroom").description("%'s bedroom is not a good place to sleep.", p(String.class, "personName")).errors(
                        error("Bed").description("This bed is freaking bad. Model: %s", p(String.class, "model")).errors(
                                error("PillowNotFound").description("There is no pillow! How can %s sleep here?", p(String.class, "personName")).build(),
                                error("BedIsWarm").description("Bed #%d is too damn warm!", p(Integer.class, "bedNumber")).build(),
                                error("BugsInfestation").description("Oh shoot, there is bug infestation here. We better move to %s.", p(String.class, "place")).build()
                        ).build(),
                        error("AlarmClock").errors(
                                error("TooEarly").description("It's just %s, still to early to wake up.", p(String.class, "time")).build(),
                                error("ShutUp").description("Shut up!, I just want to defeat the boss and get %s's legendary sword.", p(String.class, "legendaryHero")).build(),
                                error("DidNotSound").description("Oh shooooot!!! Now WTF am I supposed to do? %s is going to fire me!", p(String.class, "bossName")).build()
                        ).build()
                ).build()
        ).basePackage("com.rodrigodev.xgen.test.gen.exceptions_generator.generate").build());
        // @formatter:on
    }

    @Test
    public void generate_methodIsCalled_exceptionsGenerated() {
        assertThatThrownBy(() -> com.rodrigodev.xgen.test.gen.exceptions_generator.generate.DirtyError.throwException("Dinning Room"))
                .hasMessage("Dinning Room is dirty!");
    }
}
