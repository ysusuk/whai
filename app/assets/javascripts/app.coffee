###
  @author Yura Susuk yurasusuk@gmail.com
###

do (define) ->
  "use strict";

  define [], () ->
    WHAI = Ember.Application.create()

    WHAI.Router.map () -> @resource 'questions', {path: '/'}, () ->

    WHAI.QuestionsRoute = Ember.Route.extend
      model: () ->
        url = "http://localhost:9000/questions"
        Ember.$.getJSON url
      

    WHAI