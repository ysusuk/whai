/**
 * @author Yura Susuk yurasusuk@gmail.com
 */

(function (define) {
    "use strict";

    define(["QuestionsRoute"], function (QuestionsRoute) {
        var WHAI = Ember.Application.create();

        WHAI.Router.map(function () {
            this.resource('questions', {path: '/'}, function () {
            })
        })

        WHAI.QuestionsRoute = QuestionsRoute;

        return WHAI;
    })

}(define))