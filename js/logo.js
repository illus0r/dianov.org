let myp5 = new p5(( s ) => {
  s.setup = () => {
    s.createCanvas(64, 64)
  };

  s.draw = () => {
    s.background("#FFFFFF00")
    s.stroke(256)
    s.strokeWeight(5)
    s.noFill()
    s.scale(2)
    s.translate(10,18)
    s.beginShape()
    s.vertex(-2,0)
    s.vertex(10,0)
    s.vertex(0,10)
    s.vertex(12,10)
    s.endShape()
    s.fill(256)
    s.noStroke()
    s.ellipse(0,  -10, 7, 7) 
    s.ellipse(10, -9, 5, 5) 
  };
}, 'logo');
