/*
 * Semaforo
 */

var RED = "hsl(0, 100%, 50%)";
var YELLOW = "hsl(30, 100%, 50%)";
var GREEN = "hsl(128, 100%, 50%)";

var busy = false;

// pre-stage 
var x_psA1 = 190;
var y_psA1 = 195;
var x_psB1 = 215;
var y_psB1 = 195;
var x_psC1 = 325;
var y_psC1 = 195;
var x_psD1 = 350;
var y_psD1 = 195;

// stage
var x_psA2 = 190;
var y_psA2 = 250;
var x_psB2 = 215;
var y_psB2 = 250;
var x_psC2 = 325;
var y_psC2 = 250;
var x_psD2 = 355;
var y_psD2 = 250;

// GO
var x_YellowA1 = 185;
var y_YellowA1 = 290;
var x_YellowB1 = 190;
var y_YellowB1 = 360;
var x_YellowC1 = 185;
var y_YellowC1 = 430;

var x_YellowA2 = 300;
var y_YellowA2 = 290;
var x_YellowB2 = 295;
var y_YellowB2 = 360;
var x_YellowC2 = 295;
var y_YellowC2 = 430;

var x_Green1 = 190;
var y_Green1 = 490;

var x_Green2 = 300;
var y_Green2 = 490;

var x_Red1 = 190;
var y_Red1 = 560;

var x_Red2 = 300;
var y_Red2 = 560;

// Display

var x_display1 = 10;
var y_display1 = 10;

var x_display2 = 340;
var y_display2 = 10;

var x_dis1 = 20;
var y_dis1 = 35;
var x_disreaction1 = 20;
var y_disreaction1 = 65;
var x_disft601 = 20;
var y_disft601 = 95;
var x_dismph1 = 20;
var y_dismph1 = 130;
var x_disft13201 = 20;
var y_disft13201 = 165;

var x_dis2 = 350;
var y_dis2 = 35;	
var x_disreaction2 = 350;
var y_disreaction2 = 65;
var x_disft602 = 350;
var y_disft602 = 95;
var x_dismph2 = 350;
var y_dismph2 = 130;
var x_disft13202 = 350;
var y_disft13202 = 165;

// display
var x_entry1 = 150;
var y_entry1 = 40;
var x_react1 = 150;
var y_react1 = 70;
var x_ft601 = 150;
var y_ft601 = 100;
var x_mph1 = 150;
var y_mph1 = 135;
var x_ft13201 = 150;
var y_ft13201 = 170;
	
var x_entry2 = 480;
var y_entry2 = 40;
var x_react2 = 480;
var y_react2 = 70;
var x_ft602 = 480;
var y_ft602 = 100;
var x_mph2 = 480;
var y_mph2 = 135;
var x_ft13202 = 480;
var y_ft13202 = 170;

var trafficLightsStateMachine;
var refreshIntervalId; 

function test() {
	colorizeAndAddShort(image, YELLOW, x_psA1, y_psA1);					
	colorizeAndAddShort(image, YELLOW, x_psB1, y_psB1);
			
	colorizeAndAddShort(image, YELLOW, x_psC1, y_psC1);
	colorizeAndAddShort(image, YELLOW, x_psD1, y_psD1);
			
	colorizeAndAddShort(image, YELLOW, x_psA2, y_psA2);					
	colorizeAndAddShort(image, YELLOW, x_psB2, y_psB2);				

	colorizeAndAddShort(image, YELLOW, x_psC2, y_psC2);					
	colorizeAndAddShort(image, YELLOW, x_psD2, y_psD2);

	colorizeAndAdd(image, YELLOW, x_YellowA1, y_YellowA1);
	colorizeAndAdd(image, YELLOW, x_YellowA2, y_YellowA2);

	colorizeAndAdd(image, YELLOW, x_YellowB1, y_YellowB1);
	colorizeAndAdd(image, YELLOW, x_YellowB2, y_YellowB2);

	colorizeAndAdd(image, YELLOW, x_YellowC1, y_YellowC1);
	colorizeAndAdd(image, YELLOW, x_YellowC2, y_YellowC2);


	colorizeAndAdd(image, RED, x_Red1, y_Red1);
	colorizeAndAdd(image, GREEN, x_Green1, y_Green1);

	colorizeAndAdd(image, RED, x_Red2, y_Red2);
	colorizeAndAdd(image, GREEN, x_Green2, y_Green2); 
}

function clearContext() {
	clearInterval(refreshIntervalId);
	refreshIntervalId = 0;

	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');
	
	ctx.clearRect(0,0, canvas.width, canvas.height);
}

function prolight(statusL, statusR) {
	drawPreStageStage();
	drawGoLight(statusL, statusR);
}

function drawPreStageStage() {
	setTimeout(function() {
		colorizeAndAddShort(image, YELLOW, x_psA1, y_psA1);					
		colorizeAndAddShort(image, YELLOW, x_psB1, y_psB1);
	}, Math.floor((Math.random()*800)+1200));
			
	setTimeout(function() {
		colorizeAndAddShort(image, YELLOW, x_psC1, y_psC1);
		colorizeAndAddShort(image, YELLOW, x_psD1, y_psD1);
	}, Math.floor((Math.random()*800)+1200));
			
	setTimeout(function() {
		colorizeAndAddShort(image, YELLOW, x_psA2, y_psA2);					
		colorizeAndAddShort(image, YELLOW, x_psB2, y_psB2);				
	}, Math.floor((Math.random()*1000)+2000));
			
	setTimeout(function() {
		colorizeAndAddShort(image, YELLOW, x_psC2, y_psC2);					
		colorizeAndAddShort(image, YELLOW, x_psD2, y_psD2);
	}, Math.floor((Math.random()*1000)+2000));
}

function clearPreStageStage() {
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');
	
	ctx.clearRect(x_psA1, y_psA1, 50, 50);					
	ctx.clearRect(x_psB1, y_psB1, 50, 50);
	ctx.clearRect(x_psC1, y_psC1, 50, 50);
	ctx.clearRect(x_psD1, y_psD1, 50, 50);
	ctx.clearRect(x_psA2, y_psA2, 50, 50);					
	ctx.clearRect(x_psB2, y_psB2, 50, 50);				
	ctx.clearRect(x_psC2, y_psC2, 50, 50);					
	ctx.clearRect(x_psD2, y_psD2, 50, 50);
}

function drawGoLight(statusL, statusR) {
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');
	
	var i = 0;
	setTimeout(function() {

		for(var x = 0; x < 3; x++) {
			setTimeout(function (i) {
				if(i == 0) {
					clearPreStageStage();
					colorizeAndAdd(image, YELLOW, x_YellowA1, y_YellowA1);
					colorizeAndAdd(image, YELLOW, x_YellowA2, y_YellowA2);

					colorizeAndAdd(image, YELLOW, x_YellowB1, y_YellowB1);
					colorizeAndAdd(image, YELLOW, x_YellowB2, y_YellowB2);

					colorizeAndAdd(image, YELLOW, x_YellowC1, y_YellowC1);
					colorizeAndAdd(image, YELLOW, x_YellowC2, y_YellowC2);
				}
				
				if(i == 1) {
					ctx.clearRect(x_YellowA1, y_YellowA1, 100, 100);
					ctx.clearRect(x_YellowA2, y_YellowA2, 100, 100);
					ctx.clearRect(x_YellowB1, y_YellowB1, 100, 100);
					ctx.clearRect(x_YellowB2, y_YellowB2, 100, 100);
					ctx.clearRect(x_YellowC1, y_YellowC1, 100, 100);
					ctx.clearRect(x_YellowC2, y_YellowC2, 100, 100);
					if(statusL == 'RED') {
						colorizeAndAdd(image, RED, x_Red1, y_Red1);
					}else{
						colorizeAndAdd(image, GREEN, x_Green1, y_Green1);
					}
					if(statusR == 'RED') {
						colorizeAndAdd(image, RED, x_Red2, y_Red2);
					}else{
						colorizeAndAdd(image, GREEN, x_Green2, y_Green2);
					}
				}
				if(i == 2) {
					ctx.clearRect(x_Red1, y_Red1, 100, 100);
					ctx.clearRect(x_Green1, y_Green1, 100, 100);
					ctx.clearRect(x_Red2, y_Red2, 100, 100);
					ctx.clearRect(x_Green2, y_Green2, 100, 100);
				}
			}, 1000 * x, i);
			
			if( ++i > 4 ) i = 0;
		}
	}, 3500);
}

function drawGo() {
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');
	
	var i = 0;
	setTimeout(function() {
		for(var x = 0; x < 4; x++) {
			setTimeout(function (i) {
				if(i == 0) {
					clearPreStageStage();
					colorizeAndAdd(image, YELLOW, x_YellowA1, y_YellowA1);
					colorizeAndAdd(image, YELLOW, x_YellowA2, y_YellowA2);
				}
				
				if(i == 1) {
					ctx.clearRect(x_YellowA1, y_YellowA1, 100, 100);
					ctx.clearRect(x_YellowA2, y_YellowA2, 100, 100);
					colorizeAndAdd(image, YELLOW, x_YellowB1, y_YellowB1);
					colorizeAndAdd(image, YELLOW, x_YellowB2, y_YellowB2);
				}
				
				if(i == 2) {
					ctx.clearRect(x_YellowB1, y_YellowB1, 100, 100);
					ctx.clearRect(x_YellowB2, y_YellowB2, 100, 100);
					colorizeAndAdd(image, YELLOW, x_YellowC1, y_YellowC1);
					colorizeAndAdd(image, YELLOW, x_YellowC2, y_YellowC2);
				}
				
				if(i == 3) {
					ctx.clearRect(x_YellowC1, y_YellowC1, 100, 100);
					ctx.clearRect(x_YellowC2, y_YellowC2, 100, 100);
					colorizeAndAdd(image, GREEN, x_Green1, y_Green1);
					colorizeAndAdd(image, GREEN, x_Green2, y_Green2);
				}
				
				if(i == 4) {
					ctx.clearRect(x_Green1, y_Green1, 100, 100);
					ctx.clearRect(x_Green2, y_Green2, 100, 100);
					colorizeAndAdd(image, RED, x_Red1, y_Red1);
					colorizeAndAdd(image, RED, x_Red2, y_Red2);
				}

			}, 1000 * x, i);
			
			if( ++i > 4 ) i = 0;
		}
	}, 3500);
}

function leftWin(statusR) {
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');

	//clearContext();	
	
	if(statusR == 'RED') { colorizeAndAdd(image, RED, x_Red2, y_Red2); }

	var i = 0;
	refreshIntervalId = setInterval(function() {
		for(var x = 0; x < 5; x++) {
			setTimeout(function (i) {
				if(i == 4) {
					ctx.clearRect(x_YellowB1, y_YellowB1, 100, 100);
					colorizeAndAdd(image, YELLOW, x_YellowA1, y_YellowA1);
				}
				
				if(i == 3) {
					ctx.clearRect(x_YellowC1, y_YellowC1, 100, 100);
					colorizeAndAdd(image, YELLOW, x_YellowB1, y_YellowB1);
				}
				
				if(i == 2) {
					ctx.clearRect(x_Green1, y_Green1, 100, 100);
					colorizeAndAdd(image, YELLOW, x_YellowC1, y_YellowC1);
				}
				
				if(i == 1) {
					ctx.clearRect(x_Red1, y_Red1, 100, 100);
					colorizeAndAdd(image, GREEN, x_Green1, y_Green1);
				}
				
				if(i == 0) {
					ctx.clearRect(x_YellowA1, y_YellowA1, 100, 100);
					colorizeAndAdd(image, RED, x_Red1, y_Red1);
				}

			}, 150 * x, i);
			
			if( ++i > 4 ) i = 0;
		}
	}, 750);
}

function rightWin(statusL) {
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');

	//clearContext();		

	if(statusL == 'RED') { colorizeAndAdd(image, RED, x_Red1, y_Red1); }

	var i = 0;
	refreshIntervalId = setInterval(function() {
		for(var x = 0; x < 5; x++) {
			setTimeout(function (i) {
				if(i == 4) {
					ctx.clearRect(x_YellowB2, y_YellowB2, 100, 100);
					colorizeAndAdd(image, YELLOW, x_YellowA2, y_YellowA2);
				}
				
				if(i == 3) {
					ctx.clearRect(x_YellowC2, y_YellowC2, 100, 100);
					colorizeAndAdd(image, YELLOW, x_YellowB2, y_YellowB2);
				}
				
				if(i == 2) {
					ctx.clearRect(x_Green2, y_Green2, 100, 100);
					colorizeAndAdd(image, YELLOW, x_YellowC2, y_YellowC2);
				}
				
				if(i == 1) {
					ctx.clearRect(x_Red2, y_Red2, 100, 100);
					colorizeAndAdd(image, GREEN, x_Green2, y_Green2);
				}
				
				if(i == 0) {
					ctx.clearRect(x_YellowA2, y_YellowA2, 100, 100);
					colorizeAndAdd(image, RED, x_Red2, y_Red2);
				}

			}, 150 * x, i);
			
			if( ++i > 4 ) i = 0;
		}
	}, 750);
}


function display(ft660Left, ft660Right, ft1320Left, ft1320Right) {
	var _18mile = false;
	if( (parseFloat(ft660Left) > 0 || parseFloat(ft660Right) > 0)
		&& (parseFloat(ft1320Left) == 0 && parseFloat(ft1320Right) == 0)) {
		_18mile = true;
	}
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');

	ctx.save();
	ctx.fillStyle = "rgba(7, 0, 0, 0.5)";
   	ctx.fillRect(x_display1, y_display1, 250, 170);
	ctx.fill();

	//ctx.fillStyle = "rgba(7, 0, 0, 0.5)";
        ctx.fillRect(x_display2, y_display2, 250, 170);
	ctx.fill();

	ctx.fillRect(10,195,160,150);
	ctx.fill();

	ctx.fillRect(430,195,160,150);
	ctx.fill();

	ctx.fillStyle = 'white';
	ctx.font="normal 15px Arial";
	
	// Izquierdo
	ctx.fillText("#:",x_dis1, y_dis1);
	ctx.fillText("Reaction:",x_disreaction1, y_disreaction1);
	ctx.fillText("0-60 Foot ET:",x_disft601, y_disft601);
	if(_18mile) {
		ctx.fillText("1/8 Mile MPH:",x_dismph1, y_dismph1);
		ctx.fillText("1/8 Mile ET:",x_disft13201, y_disft13201);
	}else{
		ctx.fillText("1/4 Mile MPH:",x_dismph1, y_dismph1);
		ctx.fillText("1/4 Mile ET:",x_disft13201, y_disft13201);
	}

	// Derecho
	ctx.fillText("#:",x_dis2, y_dis2);
	ctx.fillText("Reaction:",x_disreaction2, y_disreaction2);
	ctx.fillText("0-60 Foot ET:",x_disft602, y_disft602);
	if(_18mile) {
		ctx.fillText("1/8 Mile MPH:",x_dismph2, y_dismph2);
		ctx.fillText("1/8 Mile ET:",x_disft13202, y_disft13202);
	}else{
		ctx.fillText("1/4 Mile MPH:",x_dismph2, y_dismph2);
		ctx.fillText("1/4 Mile ET:",x_disft13202, y_disft13202);
	}
	
	ctx.fillText("Piloto:",20,215);
	ctx.fillText("Piloto:",440,215);

	ctx.fillText("Carro:",20,257);
	ctx.fillText("Carro:",440,257);

	ctx.restore();
}	

function displayClean() {
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');
	ctx.clearRect(x_display1, y_display1, 250, 170);
	ctx.clearRect(x_display2, y_display2, 250, 170);
}

function timesClean() {
	times("0", "0", "0.000", "0.000", "0.000", "0.000", "0.000", "0.000", "0.000", "0.000","Piloto","Piloto","Carro","Carro","","", "0.000", "0.000");
}

function times(entryLeft, entryRight, reactionLeft, reactionRight, ft60Left, ft60Right, ft1320Left, ft1320Right, mphLeft, mphRight, pilotoLeft, pilotoRight, carLeft, carRight, flagLeft, flagRight, ft660Left, ft660Right) {
	var _18mile = false;
	if( (parseFloat(ft660Left) > 0 || parseFloat(ft660Right) > 0)
		&& (parseFloat(ft1320Left) == 0 && parseFloat(ft1320Right) == 0)) {
		_18mile = true;
	}
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');
	
	ctx.save();
	
	ctx.fillStyle = "red";
	ctx.font="normal 30px DSfont";
	ctx.shadowColor = "black";
	ctx.shadowOffsetX = 1;
	ctx.shadowOffsetY = 1;
	ctx.shadowBlur = 8;

	// Izquierdo
	ctx.fillText(entryLeft, x_entry1, y_entry1);
        ctx.fillText(reactionLeft, x_react1, y_react1);
	ctx.fillText(ft60Left, x_ft601, y_ft601);
	ctx.fillText(mphLeft, x_mph1, y_mph1);
	if(_18mile) {
		ctx.fillText(ft660Left, x_ft13201, y_ft13201);
	}else{		
		ctx.fillText(ft1320Left, x_ft13201, y_ft13201);
	}

	// Derecho
	ctx.fillText(entryRight, x_entry2, y_entry2);
        ctx.fillText(reactionRight, x_react2, y_react2);
	ctx.fillText(ft60Right, x_ft602, y_ft602);
	ctx.fillText(mphRight, x_mph2, y_mph2);
	if(_18mile) {
		ctx.fillText(ft660Right, x_ft13202, y_ft13202);
	}else{
		ctx.fillText(ft1320Right, x_ft13202, y_ft13202);
	}

	ctx.fillStyle = "white";
	ctx.font="bold 20px DSfont";
	ctx.shadowColor = "black";
	ctx.shadowOffsetX = 1;
	ctx.shadowOffsetY = 1;
	ctx.shadowBlur = 4;

	// Pilotos
	ctx.fillText((formatName(pilotoLeft)||''), 20, 240);
	ctx.fillText((formatName(pilotoRight)||''), 440, 240);

	// Carros
	ctx.fillText((formatName(carLeft)||''), 20, 283);
	ctx.fillText((formatName(carRight)||''), 440, 283);

	// flags
	if(flagLeft) {
		var flag1 = new Image();
		flag1.src = 'images/flags/' + flagLeft + '.png';
		ctx.drawImage(flag1, 70, 300, 50, 30);
	}

	if(flagRight) {
		var flag2 = new Image();
		flag2.src = 'images/flags/' + flagRight + '.png';
		 ctx.drawImage(flag2, 490, 300, 50, 30);
	}

	ctx.restore();
}


function colorizeAndAdd(image, color, x, y) {
	var output_canvas = document.getElementById('canvas');
	var output_ctx = output_canvas.getContext('2d');
	
	var tempCanvas = document.getElementById('tempCanvas');
        var tempContext = tempCanvas.getContext('2d');

	tempContext.save();
	tempContext.clearRect(0, 0, image.width, image.height);
	tempContext.fillStyle = color;
        tempContext.fillRect(0, 0, image.width, image.height);
	tempContext.globalCompositeOperation = "destination-atop";
	tempContext.drawImage(image, 0, 0, image.width, image.height);
	tempContext.restore();
	
	output_ctx.drawImage(tempCanvas, x, y);
}

function colorizeAndAddShort(image, color, x, y) {
	var output_canvas = document.getElementById('canvas');
	var output_ctx = output_canvas.getContext('2d');
	
	var tempCanvas = document.getElementById('tempCanvas');
        var tempContext = tempCanvas.getContext('2d');

	tempContext.save();
	tempContext.clearRect(0, 0, image.width, image.height);
	tempContext.fillStyle = color;
        tempContext.fillRect(0, 0, 50, 50);
	tempContext.globalCompositeOperation = "destination-atop";
	tempContext.drawImage(image, 0, 0, 50, 50);
	tempContext.restore();
	
	output_ctx.drawImage(tempCanvas, x, y);
}

function formatName(name) {
	if(!name) {
		return;
	}
	//output = name.split(" ");
	return name.substring(0, 15);
}

function resize() {
        var canvas = $("#canvas");
        var canvasWindows = canvas.parent();
        var canvasRatio = canvas.height() / canvas.width();
        var windowRatio = canvasWindows.height() / canvasWindows.width();

        var width;
        var height;
                
        if (windowRatio < canvasRatio) {
       		height = canvasWindows.height()-100;
                width = height / canvasRatio;
        } else {
                width = canvasWindows.width();
                height = width * canvasRatio;
        }

        canvas.css("width", width + 'px');
        canvas.css("height", height + 'px');
}

function timesData(time) {
	lastTime = time;
	var _18mile = false;
	if( (parseFloat(time.ft660Left) > 0 || parseFloat(time.ft660Right) > 0)
	&& (parseFloat(time.ft1320Left) == 0 && parseFloat(time.ft1320Right) == 0)) {
		_18mile = true;
	}
	
    // Historial
    var html = "<tr id="+ time.time +">" 
       + "<td>" + time.fecha + "</td>"
       + "<td id=" + time.statusLeft + ">" + time.entryLeft + "<br>" + (time.driverLeft||'') + "<br>" + (time.carLeft||'') + "</td>"
       + "<td>" + time.reactionLeft + "</td>"
       + "<td>" + time.ft60Left + "</td>"
       + "<td>" + time.mphLeft + "</td>"
       + "<td " + (time.statusLeft == 'RED' ? "style='color: red; font-weight: bold;'" : "") + ">" + 
	   + (_18mile? time.ft660Left + " *" : time.ft1320Left) + (time.firstLeft || time.statusRight ? " <span style='color: green; font-weight: bold;'>(W)</span>" : "")  + "</td>"
       + "</tr>"
       + "<tr id="+ time.time +">"
       + "<td>" + time.fecha + "</td>"
       + "<td id=" + time.statusRight + ">" + time.entryRight + "<br>" + (time.driverRight||'') + "<br>" + (time.carRight||'') + "</td>"
       + "<td>" + time.reactionRight + "</td>"
       + "<td>" + time.ft60Right + "</td>"
       + "<td>" + time.mphRight + "</td>"
       + "<td " + (time.statusRight == 'RED' ? "style='color: red; font-weight: bold;'" : "") + ">" +  
	   + (_18mile? time.ft660Right + " *" : time.ft1320Right) + (time.firstRight || time.statusLeft  ? " <span style='color: green; font-weight: bold;'>(W)</span>" : "") + "</td>"
       + "</tr>";
    
    $("#times").prepend(html);
    $("#times tr").click(function() { showPrint(this) });
	$("#container-msg").css("display","none");
	$("#container-table").css("padding-top","25px");
	$("#container-table").css("display","block");
	
    if(!busy) {
    	busy = true;
        clearContext();
        display(lastTime.ft660Left, lastTime.ft660Right, lastTime.ft1320Left, lastTime.ft1320Right);
        prolight(lastTime.statusLeft, lastTime.statusRight);
        setTimeout(function () {
            times(lastTime.entryLeft, lastTime.entryRight, lastTime.reactionLeft, lastTime.reactionRight, 
                  lastTime.ft60Left, lastTime.ft60Right, lastTime.ft1320Left, lastTime.ft1320Right, 
                  lastTime.mphLeft, lastTime.mphRight, lastTime.driverLeft, lastTime.driverRight, 
                  lastTime.carLeft, lastTime.carRight, lastTime.flagLeft, lastTime.flagRight, lastTime.ft660Left, lastTime.ft660Right);

            if(lastTime.firstLeft) {
                leftWin(lastTime.statusRight);
            }else if(lastTime.firstRight) {
                rightWin(lastTime.statusLeft);
            }else if(lastTime.statusRight) {
                leftWin();
            }else{
                rightWin();
            }
        }, 7000);
        setTimeout(function () { busy = false; }, 8000);
    }
}

var image = new Image();
image.src = 'images/A.png';

/*
 * WebSocket
 */

var stompClient = null;

var stompFailureCallback = function(error) {
	console.log('STOMP: ' + error);
    setTimeout(stompConnect, 10000);
    console.log('STOMP: Reconecting in 10 seconds');
}

function stompConnect() {
    var socket = new SockJS('/dragtree/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/dragtree/msg', function (time) {
			timesData(JSON.parse(time.body));
        });
    }, stompFailureCallback);
}

/*
 * Load
 */

$(document).ready(function() {
	window.addEventListener('load', resize, false);
	window.addEventListener('orientationchange', resize, false);

	display();
	timesClean();
	
	stompConnect();
});
