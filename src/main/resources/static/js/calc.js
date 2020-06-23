window.addEventListener("load", function(){

   var calc = document.querySelector("#calc");
   var addBtn = calc.querySelector(".add-btn");
   var form = calc.querySelector(".form");
   var addedRm = form.querySelector("div");
   var kcalView = calc.querySelector(".kcal-view");
   var target = document.getElementById("ramyun-select");
   var kcalInt =0;
   addBtn.onclick = function() {
      var kcal = document.getElementById("ramyun-select");
      var br = document.createElement("br");
      kcal = kcal.options[kcal.selectedIndex].value;
      
      kcalInt+=parseInt(kcal);
      addedRm.append(target.options[target.selectedIndex].text);
      addedRm.append(kcal+"kcal");
      addedRm.append(br);
      kcalView.append(kcal);
      console.log(kcal);
      console.log(typeof kcalInt); //num
      console.log(typeof kcalView.value); //string
      kcalView.value=kcalInt+"kcal";
      // var sum = parseInt(kcalView.value); 
      // console.log(typeof sum);
      // connsole.log(sum);
      // sum += int;
      // kcalView.value += sum; 
   }; 
});