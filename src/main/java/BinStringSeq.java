public class BinStringSeq {


	public static void main(final String[] args) {
		final String packetStart = "000000000110000000000100000";

		for (int x = 44; x >= -45; x--) {
			final String bin = Integer.toBinaryString(x);
			final StringBuilder padded = new StringBuilder(16);
			if (bin.length() < 16) {
				final int pad = 16 - bin.length();

				for (int i = 0; i < pad; i++) {
					padded.append("0");
				}

				padded.append(bin);
			}
			else if (bin.length() > 16) {
				padded.append(bin.substring(16));
			}
			else {
				padded.append(bin);
			}


			System.out.println(packetStart + padded);
		}

	}
}
