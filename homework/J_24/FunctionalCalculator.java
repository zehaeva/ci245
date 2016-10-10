import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zehaeva on 10/8/2016.
 */
public class FunctionalCalculator extends Calculator {
    private enum Operations {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        NOTHING
    }

    private Operations _last_operation = Operations.NOTHING;
    private Double _last_value = Double.NaN;


    public FunctionalCalculator() throws HeadlessException {
        this.setOutputText("0");

        super._one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(1);
            }
        });
        super._two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(2);
            }
        });
        super._three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(3);
            }
        });
        super._four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(4);
            }
        });
        super._five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(5);
            }
        });
        super._six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(6);
            }
        });
        super._seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(7);
            }
        });
        super._eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(8);
            }
        });
        super._nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(9);
            }
        });
        super._zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write(0);
            }
        });

        super._dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dot();
            }
        });

        super._add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _last_operation = Operations.ADD;
                next();
            }
        });
        super._subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _last_operation = Operations.SUBTRACT;
                next();
            }
        });
        super._multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _last_operation = Operations.MULTIPLY;
                next();
            }
        });
        super._divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _last_operation = Operations.DIVIDE;
                next();
            }
        });

        super._equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc();
            }
        });
    }

    public void next() {
        this._last_value = Double.parseDouble(super.getOutputText());
        super.setOutputText("0");
    }

    public void write(int value) {
        if (!super.getOutputText().equals("0")) {
            super.setOutputText(super.getOutputText() + value);
        }
        else {
            super.setOutputText(String.valueOf(value));
        }
    }

    public void calc() {
        switch (this._last_operation) {
            case ADD:
                this.add();
                break;
            case SUBTRACT:
                this.subtract();
                break;
            case MULTIPLY:
                this.multiply();
                break;
            case DIVIDE:
                this.divide();
                break;
        }
        this._last_operation = Operations.NOTHING;
        this._last_value = Double.NaN;
    }

    public void add() {
        double original = Double.parseDouble(super.getOutputText());

        original = original + this._last_value;

        super.setOutputText(String.format("%.2f", original));
    }

    public void subtract() {
        double original = Double.parseDouble(super.getOutputText());

        original = this._last_value - original;

        super.setOutputText(String.format("%.2f", original));
    }

    public void multiply() {
        double original = Double.parseDouble(super.getOutputText());

        original *= this._last_value;

        super.setOutputText(String.format("%.2f", original));
    }

    public void divide() {
        double original = Double.parseDouble(super.getOutputText());

        original = this._last_value / original;

        super.setOutputText(String.format("%.2f", original));
    }

    public void dot() {
        if (!super.getOutputText().matches("\\.")) {
            super.setOutputText(super.getOutputText() + '.');
        }
    }


}
