@size = $stdin.readline.to_i
@magic = $stdin.read.split(?\n).map!(&:split).map! do |line|
    line.map!(&:to_i)
end

def slant(x)
    array = []
    h = @size-1
    for i in 0..@size-1 do
        case x
            when 0
                array << @magic[i][i]
            when @size-1
                array << @magic[h][i]
        end
        h -= 1
    end
    return array
end

def sum
    for i in 0..@size-1 do
        w = @magic[i]
        unless w.include?(0)
          return w.inject(:+)
        end
        h = @magic.transpose[i]
        unless h.include?(0)
            return h.inject(:+)
        end
    end
    ls = slant(0)
    unless ls.include?(0)
        return ls.inject(:+)
    end
    rs = slant(@size-1)
    unless rs.include?(0)
        return rs.inject(:+)
    end
end

sum = sum()
skipped = false
loop do
    b = false
    for i in 0..@magic.length-1 do
        for j in 0..@magic[i].length-1 do
            if @magic[i][j] == 0
                n = -1
                if @magic[i].count(0) <= 1
                    n = sum - @magic[i].inject(:+)
                else
                    h = @magic.transpose[j]
                    if h.count(0) <= 1
                        n = sum - h.inject(:+)
                    end
                end
                if n >= 0
                    @magic[i][j] = n
                    skipped = true unless b
                else
                    b = true
                    skipped = true
                end
            end
        end
    end
    break !skipped
end
@magic.each do |line|
    puts line.join(" ")
end
