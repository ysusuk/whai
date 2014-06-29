###
  @author Yura Susuk yurasusuk@gmail.com
###

do (define) ->
  "use strict";

  define [], () ->
    WHAI = Ember.Application.create()

#    WHAI.RESTAdapter = DS.RESTAdapter.extend
#      serializer: DS.RESTSerializer.extend
#        primaryKey: (type) ->
#          '_id'
#        serializeId: (id) ->
#           id.toString
#
#    WHAI.Store = DS.Store.extend
#      adapter: 'WHAI.RESTAdapter'


    WHAI.Router.map () ->
      @resource 'questions', {path: '/'}, () ->

    WHAI.Question = DS.Model.extend
      answer: DS.attr 'boolean'
      text: DS.attr 'string'
      toggle: () ->
        @set('answer', not @get('answer'))

    WHAI.QuestionsRoute = Ember.Route.extend
      model: () ->
        @store.find('question')
      actions:
        toggle: (question) ->
          question.toggle()

    WHAI.QuestionsController = Ember.ArrayController.extend
      yes: (() ->
        questions = @store.all 'question'
        width = (questions.filterBy('answer', true).get('length') / questions.get('length')) * 100
        "width: #{width}%"
      ).property('@each.answer')
      no: (() ->
        questions = @store.all 'question'
        width = (questions.filterBy('answer', false).get('length') / questions.get('length')) * 100
        "width: #{width}%"
      ).property('@each.answer')

    WHAI