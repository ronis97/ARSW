function setup() {
    createCanvas(640, 480);
}
// Esta función se ejecuta repetidas veces indefinidamente.
function draw() {
    if (mouseIsPressed === true) {
        var color = axios.get('/getusercolor').then( color => {
            fill(color.data.r,color.data.g,color.data.b);
            ellipse(mouseX, mouseY, 20, 20);
            noStroke();
            var colorUser = {r:color.data.r,g:color.data.g,b:color.data.b};
            var point = {x:mouseX, y:mouseY, color:colorUser};
            axios.post('/drawpoints',point);
        });
    }
    if (mouseIsPressed === false) {
        fill(255,255,255);
    }
}

function refresh(){
    var points = axios.get('/drawpoints').then( points => {
        clear();
        if(points.data != null){
            for(var i = 0; i < points.data.length; i++){
                   fill(points.data[i].color.r,points.data[i].color.g,points.data[i].color.b);
                   ellipse(points.data[i].x,points.data[i].y,20,20);
                   noStroke();
            }
       }
    });
}

setInterval(refresh,1000);

function restart(){
    clear();
    axios.post('/restart');
}

function registro(){
    var user = document.getElementById("name").value;
    axios.get('/setname?name='+user);
}