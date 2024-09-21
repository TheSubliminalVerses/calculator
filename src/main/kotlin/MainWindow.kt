import java.awt.*
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

class MainWindow(private val windowName: String) : JFrame(windowName) {
    private val numberButtons = ArrayList<JButton>(10)
    private val functionButtons = ArrayList<JButton>(8)

    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var result: Double = 0.0

    private var operator: Char = '+'

    init {
        this.defaultCloseOperation = DISPOSE_ON_CLOSE
        this.size = Dimension(420, 550)
        this.layout = null

        val textField = JTextField()
        textField.bounds = Rectangle(50, 25, 300, 50)
        textField.font = Font("Arial", Font.BOLD, 30)
        textField.isEditable = false
        this.add(textField)

        val addButton = JButton("+")
        addButton.font = Font("Arial", Font.BOLD, 30)
        addButton.addActionListener({
            num1 = textField.text.toDouble()
            textField.text = ""
            operator = '+'
        })

        val subButton = JButton("-")
        subButton.addActionListener({
            num1 = textField.text.toDouble()
            textField.text = ""
            operator = '-'
        })

        val mulButton = JButton("*")
        mulButton.addActionListener({
            num1 = textField.text.toDouble()
            textField.text = ""
            operator = '*'
        })

        val divButton = JButton("/")
        divButton.addActionListener({
            num1 = textField.text.toDouble()
            textField.text = ""
            operator = '/'
        })


        val decButton = JButton(".")
        decButton.addActionListener({
            textField.text = "${textField.text}."
        })

        val negButton = JButton("(-)")
        negButton.addActionListener({
            var temp: Double = textField.text.toDouble()
            temp *= -1
            textField.text = temp.toString()

        })

        val equButton = JButton("=")
        equButton.addActionListener({
            num2 = textField.text.toDouble()

            when (operator) {
                '+' -> result = num1 + num2
                '-' -> result = num1 - num2
                '*' -> result = num1 * num2
                '/' -> result = num1 / num2
            }

            textField.text = result.toString()
            num1 = result
        })

        val delButton = JButton("DEL")
        delButton.addActionListener({
            val string = textField.text
            textField.text = ""

            for (i in 0..<string.length - 1) {
                textField.text = "${textField.text}${string[i]}"
            }
        })

        val clearButton = JButton("CLS")
        clearButton.addActionListener({
            textField.text = ""
        })

        for (i in 0..9) {
            numberButtons.add(JButton(i.toString()))
            numberButtons[i].font = Font("Arial", Font.BOLD, 30)
        }

        negButton.bounds = Rectangle(50, 430, 100, 50)
        delButton.bounds = Rectangle(150, 430, 100, 50)
        clearButton.bounds = Rectangle(250, 430, 100, 50)

        val panel = JPanel()
        panel.bounds = Rectangle(50, 100, 300, 300)
        panel.layout = GridLayout(4, 4, 10, 10)

        panel.add(numberButtons[1])
        panel.add(numberButtons[2])
        panel.add(numberButtons[3])
        panel.add(addButton)

        panel.add(numberButtons[4])
        panel.add(numberButtons[5])
        panel.add(numberButtons[6])
        panel.add(subButton)

        panel.add(numberButtons[7])
        panel.add(numberButtons[8])
        panel.add(numberButtons[9])
        panel.add(mulButton)
        panel.add(decButton)
        panel.add(numberButtons[0])
        panel.add(divButton)
        panel.add(equButton)


        this.add(panel)

        this.add(delButton)
        this.add(clearButton)
        this.add(negButton)

        for (i in 0..9) {
            numberButtons[i].addActionListener({
                textField.text = "${textField.text}${i}"
            })
        }

        this.isVisible = true
    }
}