import 'package:flutter/material.dart';
import 'dart:async';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter counter',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Flutter counter'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;


  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final int ms = 1;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Holder(ms: this.ms),
            Holder(ms: this.ms),
            Holder(ms: this.ms),
            Holder(ms: this.ms),
          ],
        ),
      ),
    );
  }
}

class Holder extends StatelessWidget {
  final int ms;
  const Holder({Key key, this.ms}) : super(key:key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: <Widget>[
          Counter(ms:ms),
          Counter(ms:ms),
          Counter(ms:ms),
          Counter(ms:ms),
          Counter(ms:ms),
          Counter(ms:ms),
        ],
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      )
    );
  }
}

class Counter extends StatefulWidget {
  final int ms;

  Counter({Key key, this.ms}) : super(key:key);

  @override
  _CounterState createState() => _CounterState();
}

class _CounterState extends State<Counter> {
  int counter = 0;

  @override
  Widget build(BuildContext context) {
    return Text("$counter");
  }

  @override
  void initState(){{
      Timer.periodic(Duration(milliseconds : widget.ms), (timer) {
        setState (() {
          counter += 1;
        });
      });
    }
  }
}


