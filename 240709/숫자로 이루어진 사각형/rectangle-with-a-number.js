const fs = require("fs");
let N = Number(fs.readFileSync(0).toString().trim());

function printRectN(N){
    let num = 1;
    for(let i=0;i<N;i++){
        let str = '';
        for(let j=0;j<N;j++){
            if(num === 10) num = 1;
            str+=`${num++} `;
        }
        console.log(str);
    }
}

printRectN(N);