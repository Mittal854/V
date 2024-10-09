var arr = [1, 2, 3, [2, 3], "hi", { name: "John" }];
arr.forEach(function (item) {
  console.log(item + " hello");
});
var ans = arr.map(function (item) {
  return item + " hello";
});
console.log(ans);

var ans1 = arr.filter((item) => {
  if (item >= 2) return true;
});
console.log(ans1);

var ans2 = arr.find((item) => {
  if (item > 2) return item;
});
console.log(ans2);

console.log(arr.indexOf(3));

var obj = {
  name: "John",
  age: 21,
};
console.log(Object.keys(obj));
Object.freeze(obj);
obj.age=25;
console.log(obj.age);

function abc(a,b,c){}
console.log(abc.length);

function a(){
    return 5;
}
var a=a();
console.log(a);

async function abc()
{
    var blob=await fetch('https://randomuser.me/api/');
    var ans=await blob.json();

    console.log(ans.results[0].name);
}
abc();