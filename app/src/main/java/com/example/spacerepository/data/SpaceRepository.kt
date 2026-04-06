package com.example.spacerepository.data

import com.example.spacerepository.R

object SpaceRepository {
    fun getSpaceObjects(): List<SpaceObject> {
        return listOf(
            // День 1: Солнце
            SpaceObject(
                day = 1,
                nameRes = R.string.day1_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day1_description,
                funFactRes = R.string.day1_fact,
                imageRes = R.drawable.solar,
                distanceRes = R.string.day1_distance,
                isCircleShape = true
            ),
            // День 2: Меркурий
            SpaceObject(
                day = 2,
                nameRes = R.string.day2_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day2_description,
                funFactRes = R.string.day2_fact,
                imageRes = R.drawable.mercury,
                distanceRes = R.string.day2_distance,
                isCircleShape = true
            ),
            // День 3: Венера
            SpaceObject(
                day = 3,
                nameRes = R.string.day3_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day3_description,
                funFactRes = R.string.day3_fact,
                imageRes = R.drawable.venus,
                distanceRes = R.string.day3_distance,
                isCircleShape = true
            ),
            // День 4: Земля
            SpaceObject(
                day = 4,
                nameRes = R.string.day4_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day4_description,
                funFactRes = R.string.day4_fact,
                imageRes = R.drawable.earth,
                distanceRes = R.string.day4_distance,
                isCircleShape = true
            ),
            // День 5: Марс
            SpaceObject(
                day = 5,
                nameRes = R.string.day5_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day5_description,
                funFactRes = R.string.day5_fact,
                imageRes = R.drawable.mars,
                distanceRes = R.string.day5_distance,
                isCircleShape = true
            ),
            // День 6: Пояс астероидов
            SpaceObject(
                day = 6,
                nameRes = R.string.day6_name,
                categoryRes = Category.Belt,
                descriptionRes = R.string.day6_description,
                funFactRes = R.string.day6_fact,
                imageRes = R.drawable.asteroid_belt,
                distanceRes = R.string.day6_distance,
                isCircleShape = false
            ),
            // День 7: Церера
            SpaceObject(
                day = 7,
                nameRes = R.string.day7_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day7_description,
                funFactRes = R.string.day7_fact,
                imageRes = R.drawable.ceres,
                distanceRes = R.string.day7_distance,
                isCircleShape = true
            ),
            // День 8: Юпитер
            SpaceObject(
                day = 8,
                nameRes = R.string.day8_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day8_description,
                funFactRes = R.string.day8_fact,
                imageRes = R.drawable.jupiter,
                distanceRes = R.string.day8_distance,
                isCircleShape = true
            ),
            // День 9: Сатурн
            SpaceObject(
                day = 9,
                nameRes = R.string.day9_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day9_description,
                funFactRes = R.string.day9_fact,
                imageRes = R.drawable.saturn,
                distanceRes = R.string.day9_distance,
                isCircleShape = true
            ),
            // День 10: Уран
            SpaceObject(
                day = 10,
                nameRes = R.string.day10_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day10_description,
                funFactRes = R.string.day10_fact,
                imageRes = R.drawable.uran,
                distanceRes = R.string.day10_distance,
                isCircleShape = true
            ),
            // День 11: Нептун
            SpaceObject(
                day = 11,
                nameRes = R.string.day11_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day11_description,
                funFactRes = R.string.day11_fact,
                imageRes = R.drawable.neptune,
                distanceRes = R.string.day11_distance,
                isCircleShape = true
            ),
            // День 12: Плутон
            SpaceObject(
                day = 12,
                nameRes = R.string.day12_name,
                categoryRes = Category.Planet,
                descriptionRes = R.string.day12_description,
                funFactRes = R.string.day12_fact,
                imageRes = R.drawable.pluto,
                distanceRes = R.string.day12_distance,
                isCircleShape = true
            ),
            // День 13: Пояс Койпера
            SpaceObject(
                day = 13,
                nameRes = R.string.day13_name,
                categoryRes = Category.Belt,
                descriptionRes = R.string.day13_description,
                funFactRes = R.string.day13_fact,
                imageRes = R.drawable.kuiper_belt,
                distanceRes = R.string.day13_distance,
                isCircleShape = false
            ),
            // День 14: Облако Оорта
            SpaceObject(
                day = 14,
                nameRes = R.string.day14_name,
                categoryRes = Category.Belt,
                descriptionRes = R.string.day14_description,
                funFactRes = R.string.day14_fact,
                imageRes = R.drawable.aorta,
                distanceRes = R.string.day14_distance,
                isCircleShape = false
            ),
            // День 15: Проксима Центавра
            SpaceObject(
                day = 15,
                nameRes = R.string.day15_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day15_description,
                funFactRes = R.string.day15_fact,
                imageRes = R.drawable.proxima_centauri,
                distanceRes = R.string.day15_distance,
                isCircleShape = true
            ),
            // День 16: Сириус
            SpaceObject(
                day = 16,
                nameRes = R.string.day16_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day16_description,
                funFactRes = R.string.day16_fact,
                imageRes = R.drawable.sirius,
                distanceRes = R.string.day16_distance,
                isCircleShape = true
            ),
            // День 17: Вега
            SpaceObject(
                day = 17,
                nameRes = R.string.day17_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day17_description,
                funFactRes = R.string.day17_fact,
                imageRes = R.drawable.vega,
                distanceRes = R.string.day17_distance,
                isCircleShape = true
            ),
            // День 18: Арктур
            SpaceObject(
                day = 18,
                nameRes = R.string.day18_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day18_description,
                funFactRes = R.string.day18_fact,
                imageRes = R.drawable.arcturus,
                distanceRes = R.string.day18_distance,
                isCircleShape = true
            ),
            // День 19: Бетельгейзе
            SpaceObject(
                day = 19,
                nameRes = R.string.day19_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day19_description,
                funFactRes = R.string.day19_fact,
                imageRes = R.drawable.betelgeuse,
                distanceRes = R.string.day19_distance,
                isCircleShape = true
            ),
            // День 20: Ригель
            SpaceObject(
                day = 20,
                nameRes = R.string.day20_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day20_description,
                funFactRes = R.string.day20_fact,
                imageRes = R.drawable.rigel,
                distanceRes = R.string.day20_distance,
                isCircleShape = true
            ),
            // День 21: Антарес
            SpaceObject(
                day = 21,
                nameRes = R.string.day21_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day21_description,
                funFactRes = R.string.day21_fact,
                imageRes = R.drawable.antares,
                distanceRes = R.string.day21_distance,
                isCircleShape = true
            ),
            // День 22: Полярная звезда
            SpaceObject(
                day = 22,
                nameRes = R.string.day22_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day22_description,
                funFactRes = R.string.day22_fact,
                imageRes = R.drawable.polaris,
                distanceRes = R.string.day22_distance,
                isCircleShape = true
            ),
            // День 23: Эта Киля
            SpaceObject(
                day = 23,
                nameRes = R.string.day23_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day23_description,
                funFactRes = R.string.day23_fact,
                imageRes = R.drawable.eta_carinae,
                distanceRes = R.string.day23_distance,
                isCircleShape = true
            ),
            // День 24: UY Щита
            SpaceObject(
                day = 24,
                nameRes = R.string.day24_name,
                categoryRes = Category.Star,
                descriptionRes = R.string.day24_description,
                funFactRes = R.string.day24_fact,
                imageRes = R.drawable.uy_scuti,
                distanceRes = R.string.day24_distance,
                isCircleShape = true
            ),
            // День 25: Черная дыра (Стрелец А*)
            SpaceObject(
                day = 25,
                nameRes = R.string.day25_name,
                categoryRes = Category.Other,
                descriptionRes = R.string.day25_description,
                funFactRes = R.string.day25_fact,
                imageRes = R.drawable.sagittarius_a,
                distanceRes = R.string.day25_distance,
                isCircleShape = false
            ),
            // День 26: Туманность Орел
            SpaceObject(
                day = 26,
                nameRes = R.string.day26_name,
                categoryRes = Category.Nebula,
                descriptionRes = R.string.day26_description,
                funFactRes = R.string.day26_fact,
                imageRes = R.drawable.eagle_nebula,
                distanceRes = R.string.day26_distance,
                isCircleShape = false
            ),
            // День 27: Пульсар
            SpaceObject(
                day = 27,
                nameRes = R.string.day27_name,
                categoryRes = Category.Other,
                descriptionRes = R.string.day27_description,
                funFactRes = R.string.day27_fact,
                imageRes = R.drawable.pulsar,
                distanceRes = R.string.day27_distance,
                isCircleShape = true
            ),
            // День 28: Квазар
            SpaceObject(
                day = 28,
                nameRes = R.string.day28_name,
                categoryRes = Category.Other,
                descriptionRes = R.string.day28_description,
                funFactRes = R.string.day28_fact,
                imageRes = R.drawable.quasar,
                distanceRes = R.string.day28_distance,
                isCircleShape = false
            ),
            // День 29: Млечный Путь
            SpaceObject(
                day = 29,
                nameRes = R.string.day29_name,
                categoryRes = Category.Other,
                descriptionRes = R.string.day29_description,
                funFactRes = R.string.day29_fact,
                imageRes = R.drawable.milky_way,
                distanceRes = R.string.day29_distance,
                isCircleShape = false
            ),
            // День 30: Край Вселенной
            SpaceObject(
                day = 30,
                nameRes = R.string.day30_name,
                categoryRes = Category.Other,
                descriptionRes = R.string.day30_description,
                funFactRes = R.string.day30_fact,
                imageRes = R.drawable.great_attractor,
                distanceRes = R.string.day30_distance,
                isCircleShape = false
            )
        )
    }
}