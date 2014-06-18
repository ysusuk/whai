/**
 * @author Yura Susuk yurasusuk@gmail.com
 */

(function (define) {
    "use strict";

    define([], function (QuestionsRoute) {
        var WHAI = Ember.Application.create();

        WHAI.Router.map(function () {
            this.resource('questions', {path: '/'}, function () {
            })
        })

        WHAI.QuestionsRoute = Ember.Route.extend({
          model: function() {
              var url = "http://localhost:9000/questions";
              return Ember.$.getJSON(url);
          }
        });

        return WHAI;
    })

}(define))