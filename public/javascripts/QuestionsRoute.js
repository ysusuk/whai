/**
 * @author Yura Susuk yurasusuk@gmail.com
 */

(function (define) {
    "use strict";

    define([], function () {
        var QuestionsRoute = Ember.Route.extend({
            model: function () {
                var questions = [];

                questions.pushObject(Ember.Object.create({
                    id: 1,
                    text: "You are almost never late for your appointments?",
                    answer: null
                }));

                questions.pushObject(Ember.Object.create({
                    id: 2,
                    text: "You like to be engaged in an active and fast-paced job?",
                    answer: null
                }));

                questions.pushObject(Ember.Object.create({
                    id: 3,
                    text: "You enjoy having a wide circle of acquaintances?",
                    answer: null
                }));

                questions.pushObject(Ember.Object.create({
                    id: 4,
                    text: "You feel involved when watching TV soaps?",
                    answer: null
                }));

                questions.pushObject(Ember.Object.create({
                    id: 5,
                    text: "You are usually the first to react to a sudden event, such as the telephone ringing or unexpected question?",
                    answer: null
                }));

                return questions;
            }
        })

        return QuestionsRoute;
    })
}(define))
