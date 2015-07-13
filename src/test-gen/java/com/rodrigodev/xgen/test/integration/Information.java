package com.rodrigodev.xgen.test.integration;

import com.rodrigodev.xgen.test.integration.ErrorInfo.PlainTextErrorDescription;
import com.rodrigodev.xgen.test.integration.ErrorInfo.CustomMessageGeneratorErrorDescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Autogenerated by XGen on July 13, 2015.
 */
public class Information {

    private static List<ErrorInfo> errorInfoList;
    private static Map<String, ErrorInfo> idToErrorInfoMap;
    private static Map<String, ErrorInfo> numericIdToErrorInfoMap;

    private static final AtomicBoolean loaded = new AtomicBoolean();

    private static void load() {
        if (loaded.compareAndSet(false, true)) {
            errorInfoList = new ArrayList<>();

            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.HouseError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.HouseException.class),
                com.rodrigodev.xgen.test.integration.HouseError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.CommonError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.CommonException.class),
                com.rodrigodev.xgen.test.integration.common.CommonError.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.room.RoomError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.room.RoomException.class),
                com.rodrigodev.xgen.test.integration.common.room.RoomError.CODE,
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.room.dirty.DirtyError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.room.dirty.DirtyException.class),
                com.rodrigodev.xgen.test.integration.common.room.dirty.DirtyError.CODE,
                new PlainTextErrorDescription("%s is dirty!"),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.room.too_small.TooSmallError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.room.too_small.TooSmallException.class),
                com.rodrigodev.xgen.test.integration.common.room.too_small.TooSmallError.CODE,
                new PlainTextErrorDescription("%s is too damn small!"),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.room.bad_smell.BadSmellError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.room.bad_smell.BadSmellException.class),
                com.rodrigodev.xgen.test.integration.common.room.bad_smell.BadSmellError.CODE,
                new PlainTextErrorDescription("The %s smells bad, really bad."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.appliance.ApplianceException.class),
                com.rodrigodev.xgen.test.integration.common.appliance.ApplianceError.CODE,
                new PlainTextErrorDescription("Something went wrong with %s appliance."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.appliance.damaged.DamagedError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.appliance.damaged.DamagedException.class),
                com.rodrigodev.xgen.test.integration.common.appliance.damaged.DamagedError.CODE,
                new PlainTextErrorDescription("The %s has been damaged."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.appliance.discharged.DischargedError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.appliance.discharged.DischargedException.class),
                com.rodrigodev.xgen.test.integration.common.appliance.discharged.DischargedError.CODE,
                new PlainTextErrorDescription("The %s is discharged."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.common.appliance.scratches.ScratchesError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.common.appliance.scratches.ScratchesException.class),
                com.rodrigodev.xgen.test.integration.common.appliance.scratches.ScratchesError.CODE,
                new PlainTextErrorDescription("The %s got some scratches."),
                true
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.KitchenError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.KitchenException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.KitchenException.class),
                com.rodrigodev.xgen.test.integration.kitchen.KitchenError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeException.class),
                com.rodrigodev.xgen.test.integration.kitchen.fridge.FridgeError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.fridge.food_not_found.FoodNotFoundError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.fridge.food_not_found.FoodNotFoundException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.fridge.food_not_found.FoodNotFoundException.class),
                com.rodrigodev.xgen.test.integration.kitchen.fridge.food_not_found.FoodNotFoundError.CODE,
                new PlainTextErrorDescription("Food %s not found! I'm starving."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.fridge.frozen_food.FrozenFoodError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.fridge.frozen_food.FrozenFoodException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.fridge.frozen_food.FrozenFoodException.class),
                com.rodrigodev.xgen.test.integration.kitchen.fridge.frozen_food.FrozenFoodError.CODE,
                new PlainTextErrorDescription("The %s is frozen! How could you possibly eat that?"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.fridge.rotten_food.RottenFoodError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.fridge.rotten_food.RottenFoodException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.fridge.rotten_food.RottenFoodException.class),
                com.rodrigodev.xgen.test.integration.kitchen.fridge.rotten_food.RottenFoodError.CODE,
                new PlainTextErrorDescription("The %s is rotten my friend."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.oven.OvenError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.oven.OvenException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.oven.OvenException.class),
                com.rodrigodev.xgen.test.integration.kitchen.oven.OvenError.CODE,
                new PlainTextErrorDescription("The oven is not working. Model: %s"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.oven.undercooked.UndercookedError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.oven.undercooked.UndercookedException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.oven.undercooked.UndercookedException.class),
                com.rodrigodev.xgen.test.integration.kitchen.oven.undercooked.UndercookedError.CODE,
                new PlainTextErrorDescription("The %s is undercooked my friend, I won't eat that."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.oven.burned_food.BurnedFoodError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.oven.burned_food.BurnedFoodException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.oven.burned_food.BurnedFoodException.class),
                com.rodrigodev.xgen.test.integration.kitchen.oven.burned_food.BurnedFoodError.CODE,
                new PlainTextErrorDescription("Damn, the %s just burned! We better order some pizza."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.kitchen.oven.too_much_smoke.TooMuchSmokeError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.kitchen.oven.too_much_smoke.TooMuchSmokeException.TYPE, com.rodrigodev.xgen.test.integration.kitchen.oven.too_much_smoke.TooMuchSmokeException.class),
                com.rodrigodev.xgen.test.integration.kitchen.oven.too_much_smoke.TooMuchSmokeError.CODE,
                new PlainTextErrorDescription("Wow, there is too much smoke coming out from the oven. Do you think the %s is okay?"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.BedroomError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.BedroomException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.BedroomException.class),
                com.rodrigodev.xgen.test.integration.bedroom.BedroomError.CODE,
                new PlainTextErrorDescription("%s's bedroom is not a good place to sleep."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.bed.BedError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.bed.BedException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.bed.BedException.class),
                com.rodrigodev.xgen.test.integration.bedroom.bed.BedError.CODE,
                new PlainTextErrorDescription("This bed is freaking bad. Model: %s"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.bed.pillow_not_found.PillowNotFoundError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.bed.pillow_not_found.PillowNotFoundException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.bed.pillow_not_found.PillowNotFoundException.class),
                com.rodrigodev.xgen.test.integration.bedroom.bed.pillow_not_found.PillowNotFoundError.CODE,
                new PlainTextErrorDescription("There is no pillow! How can %s sleep here?"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.bed.bed_is_warm.BedIsWarmError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.bed.bed_is_warm.BedIsWarmException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.bed.bed_is_warm.BedIsWarmException.class),
                com.rodrigodev.xgen.test.integration.bedroom.bed.bed_is_warm.BedIsWarmError.CODE,
                new PlainTextErrorDescription("Bed #%d is too damn warm!"),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.bed.bugs_infestation.BugsInfestationError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.bed.bugs_infestation.BugsInfestationException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.bed.bugs_infestation.BugsInfestationException.class),
                com.rodrigodev.xgen.test.integration.bedroom.bed.bugs_infestation.BugsInfestationError.CODE,
                new PlainTextErrorDescription("Oh shoot, there is bug infestation here. We better move to %s."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockException.class),
                com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.AlarmClockError.CODE,
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.too_early.TooEarlyError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.too_early.TooEarlyException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.too_early.TooEarlyException.class),
                com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.too_early.TooEarlyError.CODE,
                new PlainTextErrorDescription("It's just %s, still to early to wake up."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.shut_up.ShutUpError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.shut_up.ShutUpException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.shut_up.ShutUpException.class),
                com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.shut_up.ShutUpError.CODE,
                new PlainTextErrorDescription("Shut up!, I just want to defeat the boss and get %s's legendary sword."),
                false
            ));
            errorInfoList.add(new ErrorInfo(
                com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.did_not_sound.DidNotSoundError.class,
                new ExceptionInfo(com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.did_not_sound.DidNotSoundException.TYPE, com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.did_not_sound.DidNotSoundException.class),
                com.rodrigodev.xgen.test.integration.bedroom.alarm_clock.did_not_sound.DidNotSoundError.CODE,
                new PlainTextErrorDescription("Oh shooooot!!! Now WTF am I supposed to do? %s is going to fire me!"),
                false
            ));

            errorInfoList = Collections.unmodifiableList(errorInfoList);
            loaded.set(true);
        }
    }

    public static List<ErrorInfo> list() {
        load();
        return errorInfoList;
    }

    public static ErrorInfo forId(String id) {
        if (id == null) throw new IllegalArgumentException("id");

        load();
        return idToErrorInfoMap.get(id);
    }

    public static ErrorInfo forNumericId(String numericId) {
        if (numericId == null) throw new IllegalArgumentException("numericId");

        load();
        return numericIdToErrorInfoMap.get(numericId);
    }
}
