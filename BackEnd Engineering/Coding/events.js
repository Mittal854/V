import { EventEmitter } from "node:events";
const event = new EventEmitter();

var list1 = function list1() {
  console.log("Function list1 is executed");
};

var list2 = function list2() {
  console.log("Function list2 is executed");
};

event.addListener("newfun", list1);
event.on("newfun", list2);
event.emit("newfun");

event.removeListener("newfun", list1);
console.log("list1 removed");

event.emit("newfun");
