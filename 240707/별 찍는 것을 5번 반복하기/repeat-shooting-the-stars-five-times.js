const printFiveStars = ()=>{
    let s = '';
    for(let i=0;i<10;i++){
        s+='*';
    }
    console.log(s);
};

for(let i=0;i<5;i++){
    printFiveStars();
}