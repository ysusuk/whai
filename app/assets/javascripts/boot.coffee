###
  @author Yura Susuk yurasusuk@gmail.com
###

do (head = window.head) ->
  "use strict";

  head.css [
    'http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700,300italic,400italic,500italic,700italic'
    'http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,300,400,600,700,800'
    'assets/javascripts/bower_components/bootstrap/dist/css/bootstrap.css'
    'assets/stylesheets/main.css'
  ]

  head.js(
    {
      jquery: "assets/javascripts/bower_components/jquery/jquery.js"
      size: 267000
    },
    {
      bootstrap: "assets/javascripts/bower_components/bootstrap/dist/js/bootstrap.js"
      size: 59000
    },
    {
      require: 'assets/javascripts/bower_components/requirejs/require.js'
      size: 82678
    },
    {
      handlebars: "assets/javascripts/bower_components/handlebars/handlebars.js"
      size: 16000
    },
    {
      ember: "assets/javascripts/bower_components/ember/ember.js",
      size: 1200000
    },
    {
      ember: "assets/javascripts/bower_components/ember-data/ember-data.js",
      size: 341000
    })

  head.ready 'ALL', () ->
    require.config
      appDir: ''
      baseUrl: 'assets/javascripts'
      paths:
        shim:
          'underscore':
            exports: '_'
    require ['app'], (app) ->
      window.WHAI = app