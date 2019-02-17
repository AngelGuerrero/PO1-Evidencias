/**
 * @Author: Luis Ángel De Santiago Guerrero
 * @Date:   2017-08-08T16:10:31-05:00
 * @Email:  _angelguerrero_@outlook.com
 * @Filename: Task.java
 * @Last modified by:   Luis Ángel De Santiago Guerrero
 * @Last modified time: 2017-08-09T06:08:34-05:00
 * @License: MIT
 */



package main;

public class Task {

  private String _name;
  private boolean _done;

  public Task(String _name, boolean _done) {
    this._name = _name;
    this._done = _done;
  }

  public Task() {
    this._name = "";
    this._done = false;
  }

  public String get_name() {
    return _name;
  }

  public void set_name(String _name) {
    this._name = _name;
  }

  public boolean is_done() {
    return _done;
  }

  public void set_done(boolean _done) {
    this._done = _done;
  }
}
