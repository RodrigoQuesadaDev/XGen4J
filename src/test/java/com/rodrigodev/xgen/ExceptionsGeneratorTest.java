package com.rodrigodev.xgen;

import com.rodrigodev.xgen.test.gen.exceptions_generator.generate.*;
import org.junit.Test;

import static com.rodrigodev.xgen.configuration.ErrorConfiguration.*;
import static com.rodrigodev.xgen.configuration.ParameterDefinition.p;
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
                                error("Dirty").description("%s is dirty!", p(String.class, "roomName")),
                                error("TooSmall").description("%s is too damn small!", p(String.class, "roomName")),
                                error("BadSmell").description("The %s smells bad, really bad.", p(String.class, "roomName"))
                        ),
                        error("Appliance").description("Something went wrong with %s appliance.", p(String.class, "applianceName")).errors(
                                error("Damaged").description("The %s has been damaged.", p(String.class, "applianceName")),
                                error("Discharged").description("The %s is discharged.", p(String.class, "applianceName")),
                                error("Scratches").description("The %s got some scratches.", p(String.class, "applianceName"))
                        )
                ),
                error("Kitchen").errors(
                        error("Fridge").errors(
                                error("FoodNotFound").description("Food %s not found! I'm starving.", p(String.class, "foodName")),
                                error("FrozenFood").description("The %s is frozen! How could you possibly eat that?", p(String.class, "foodName")),
                                error("RottenFood").description("The %s is rotten my friend.", p(String.class, "foodName"))
                        ),
                        error("Oven").description("The oven is not working. Model: %s", p(String.class, "model")).errors(
                                error("Undercooked").description("The %s is undercooked my friend, I won't eat that.", p(String.class, "model")),
                                error("BurnedFood").description("Damn, the %s just burned! We better order some pizza.", p(String.class, "model")),
                                error("TooMuchSmoke").description("Wow, there is too much smoke coming out from the oven. Do you think the %s is okay?", p(String.class, "model"))
                        )
                ),
                error("Bedroom").description("%s's bedroom is not a good place to sleep.", p(String.class, "personName")).errors(
                        error("Bed").description("This bed is freaking bad. Model: %s", p(String.class, "model")).errors(
                                error("PillowNotFound").description("There is no pillow! How can %s sleep here?", p(String.class, "personName")),
                                error("BedIsWarm").description("Bed #%d is too damn warm!", p(Integer.class, "bedNumber")),
                                error("BugsInfestation").description("Oh shoot, there is bug infestation here. We better move to %s.", p(String.class, "place"))
                        ),
                        error("AlarmClock").errors(
                                error("TooEarly").description("It's just %s, still to early to wake up.", p(String.class, "time")),
                                error("ShutUp").description("Shut up!, I just want to defeat the boss and get %s's legendary sword.", p(String.class, "legendaryHero")),
                                error("DidNotSound").description("Oh shooooot!!! Now WTF am I supposed to do? %s is going to fire me!", p(String.class, "bossName"))
                        )
                )
        ).basePackage("com.rodrigodev.xgen.test.gen.exceptions_generator.generate").build());
        // @formatter:on
    }

    @Test
    public void thrownExceptionsHaveCorrectMessage() {

        assertThatThrownBy(() -> DirtyError
                .throwException("Dinning Room"))
                .hasMessage("Dinning Room is dirty!");

        assertThatThrownBy(() -> TooSmallError
                .throwException("Bathroom"))
                .hasMessage("Bathroom is too damn small!");

        assertThatThrownBy(() -> BadSmellError
                .throwException("toilet"))
                .hasMessage("The toilet smells bad, really bad.");

        assertThatThrownBy(() -> ApplianceError
                .throwException("blender"))
                .hasMessage("Something went wrong with blender appliance.");

        assertThatThrownBy(() -> DamagedError
                .throwException("microwave"))
                .hasMessage("The microwave has been damaged.");

        assertThatThrownBy(() -> DischargedError
                .throwException("tablet"))
                .hasMessage("The tablet is discharged.");

        assertThatThrownBy(() -> ScratchesError
                .throwException("TV"))
                .hasMessage("The TV got some scratches.");

        assertThatThrownBy(() -> FoodNotFoundError
                .throwException("carrot"))
                .hasMessage("Food carrot not found! I'm starving.");

        assertThatThrownBy(() -> FrozenFoodError
                .throwException("meat"))
                .hasMessage("The meat is frozen! How could you possibly eat that?");

        assertThatThrownBy(() -> RottenFoodError
                .throwException("fish"))
                .hasMessage("The fish is rotten my friend.");

        assertThatThrownBy(() -> OvenError
                .throwException("ACME-123"))
                .hasMessage("The oven is not working. Model: ACME-123");

        assertThatThrownBy(() -> UndercookedError
                .throwException("cake"))
                .hasMessage("The cake is undercooked my friend, I won't eat that.");

        assertThatThrownBy(() -> BurnedFoodError
                .throwException("Schnitzel"))
                .hasMessage("Damn, the Schnitzel just burned! We better order some pizza.");

        assertThatThrownBy(() -> TooMuchSmokeError
                .throwException("turkey"))
                .hasMessage("Wow, there is too much smoke coming out from the oven. Do you think the turkey is okay?");

        assertThatThrownBy(() -> BedroomError
                .throwException("Scott Lang"))
                .hasMessage("Scott Lang's bedroom is not a good place to sleep.");

        assertThatThrownBy(() -> BedError
                .throwException("FAKE-SLP-45"))
                .hasMessage("This bed is freaking bad. Model: FAKE-SLP-45");

        assertThatThrownBy(() -> PillowNotFoundError
                .throwException("Arthur Curry"))
                .hasMessage("There is no pillow! How can Arthur Curry sleep here?");

        assertThatThrownBy(() -> BedIsWarmError
                .throwException(789))
                .hasMessage("Bed #789 is too damn warm!");

        assertThatThrownBy(() -> BugsInfestationError
                .throwException("Alabama"))
                .hasMessage("Oh shoot, there is bug infestation here. We better move to Alabama.");

        assertThatThrownBy(() -> TooEarlyError
                .throwException("11:15 p.m."))
                .hasMessage("It's just 11:15 p.m., still to early to wake up.");

        assertThatThrownBy(() -> ShutUpError
                .throwException("He-Man"))
                .hasMessage("Shut up!, I just want to defeat the boss and get He-Man's legendary sword.");

        assertThatThrownBy(() -> DidNotSoundError
                .throwException("J. Jonah Jameson"))
                .hasMessage("Oh shooooot!!! Now WTF am I supposed to do? J. Jonah Jameson is going to fire me!");
    }

    @Test
    public void thrownExceptionsAreOfCorrectType() {

        assertThatThrownBy(() -> DirtyError
                .throwException("Dinning Room"))
                .isExactlyInstanceOf(DirtyException.class);

        assertThatThrownBy(() -> TooSmallError
                .throwException("Bathroom"))
                .isExactlyInstanceOf(TooSmallException.class);

        error("BadSmell").description("The %s smells bad, really bad.", p(String.class, "roomName"));
        error("Appliance").description("Something went wrong with %s appliance.", p(String.class, "applianceName"));
        error("Damaged").description("%s has been damaged.", p(String.class, "applianceName"));
        error("Discharged").description("%s is discharged.", p(String.class, "applianceName"));
        error("Scratches").description("%s got some scratches.", p(String.class, "applianceName"));
        error("FoodNotFound").description("Food %s not found! I'm starving.", p(String.class, "foodName"));
        error("FrozenFood").description("%s is frozen! How could you possibly eat that?", p(String.class, "foodName"));
        error("RottenFood").description("%s is rotten my friend.", p(String.class, "foodName"));
        error("Oven").description("The oven is not working. Model: %s", p(String.class, "model"));
        error("Undercooked").description("%s is undercooked my friend, I won't eat that.", p(String.class, "model"));
        error("BurnedFood").description("Damn, %s just burned! We better order some pizza.", p(String.class, "model"));
        error("TooMuchSmoke").description("Wow, there is too much smoke coming out from the oven. Do you think %s is okay?", p(String.class, "model"));
        error("Bedroom").description("%'s bedroom is not a good place to sleep.", p(String.class, "personName"));
        error("Bed").description("This bed is freaking bad. Model: %s", p(String.class, "model"));
        error("PillowNotFound").description("There is no pillow! How can %s sleep here?", p(String.class, "personName"));
        error("BedIsWarm").description("Bed #%d is too damn warm!", p(Integer.class, "bedNumber"));
        error("BugsInfestation").description("Oh shoot, there is bug infestation here. We better move to %s.", p(String.class, "place"));
        error("TooEarly").description("It's just %s, still to early to wake up.", p(String.class, "time"));
        error("ShutUp").description("Shut up!, I just want to defeat the boss and get %s's legendary sword.", p(String.class, "legendaryHero"));
        error("DidNotSound").description("Oh shooooot!!! Now WTF am I supposed to do? %s is going to fire me!", p(String.class, "bossName"));
    }
}
