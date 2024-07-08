const fs = require("fs");
let N = Number(fs.readFileSync(0).toString().trim());

function printN(N){
    for(let i=0;i<N;i++){
        console.log('12345^&*()_');
    }
}

printN(N);